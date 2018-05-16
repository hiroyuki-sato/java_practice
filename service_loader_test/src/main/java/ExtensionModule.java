import com.google.inject.Binder;
import com.google.inject.Module;

import java.util.List;
import java.util.ServiceLoader;

public class ExtensionModule implements Module
{
    @Override
    public void configure(Binder binder){
        ServiceLoader<Extension> serviceLoader = ServiceLoader.load(Extension.class);
        for( Extension extension : serviceLoader ){
            for( Module module : extension.getModules() ){
                module.configure(binder);
            }
        }
    }
}
