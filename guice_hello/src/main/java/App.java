import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class App {
    @Inject
    private HelloWorld helloWorld;


    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override protected void configure() {}
        });

        App main = injector.getInstance(App.class);
        main.helloWorld.hello();

    }
}
