import com.google.inject.Module;

import java.util.List;

public interface Extension
{
    List<Module> getModules();
}
