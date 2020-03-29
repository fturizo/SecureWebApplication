package fish.payara.demos.services;

import fish.payara.demos.entities.User;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class DataInitializer {
    
    @Inject
    DataService dataService;
    
    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event){
        if(dataService.getAllUsers().isEmpty()){
            User sally = dataService.createUser("Sally Addams", "saddams", "saddams", "admin");
            User tom = dataService.createUser("Tom Matthews", "tmatthews", "tmatthews", "user");
            
            dataService.createQuality("Wonderful", sally);
            dataService.createQuality("Team Player", sally);
            dataService.createQuality("Good Judgement", sally);
            dataService.createQuality("Good Leader", sally);
            
            dataService.createQuality("Dilligent", tom);
            dataService.createQuality("Responsible", tom);
            dataService.createQuality("Cares for his teammates", tom);
        }
    }
}
