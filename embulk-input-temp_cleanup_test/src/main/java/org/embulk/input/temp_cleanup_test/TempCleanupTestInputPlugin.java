package org.embulk.input.temp_cleanup_test;

import java.io.File;
import java.util.List;
import java.util.Locale;

import com.google.common.base.Optional;
import org.embulk.config.TaskReport;
import org.embulk.config.Config;
import org.embulk.config.ConfigDefault;
import org.embulk.config.ConfigDiff;
import org.embulk.config.ConfigSource;
import org.embulk.config.Task;
import org.embulk.config.TaskSource;
import org.embulk.spi.Exec;
import org.embulk.spi.InputPlugin;
import org.embulk.spi.PageOutput;
import org.embulk.spi.Schema;
import org.embulk.spi.SchemaConfig;
import org.embulk.spi.TempFileSpace;
import org.slf4j.Logger;

public class TempCleanupTestInputPlugin
        implements InputPlugin
{
    private static final Logger logger = Exec.getLogger(TempCleanupTestInputPlugin.class);
    public interface PluginTask
            extends Task
    {
        // if you get schema from config
        @Config("columns")
        public SchemaConfig getColumns();
    }

    @Override
    public ConfigDiff transaction(ConfigSource config,
            InputPlugin.Control control)
    {
        PluginTask task = config.loadConfig(PluginTask.class);

        Schema schema = task.getColumns().toSchema();
        int taskCount = 1;  // number of run() method calls
        logger.info(String.format(Locale.ENGLISH,"transaction called"));

        return resume(task.dump(), schema, taskCount, control);
    }

    @Override
    public ConfigDiff resume(TaskSource taskSource,
            Schema schema, int taskCount,
            InputPlugin.Control control)
    {
        control.run(taskSource, schema, taskCount);
        logger.info(String.format(Locale.ENGLISH,"resume called"));
        return Exec.newConfigDiff();
    }

    @Override
    public void cleanup(TaskSource taskSource,
            Schema schema, int taskCount,
            List<TaskReport> successTaskReports)
    {
        logger.info(String.format(Locale.ENGLISH,"cleanup called"));

        // ディレクトリを削除するコードを入れない限り、TempFileSpaceのディレクトリは削除されない。
/*
        File file = new File("/tmp/aaa");
        try {
            recursiveDeleteFile(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

    @Override
    public TaskReport run(TaskSource taskSource,
            Schema schema, int taskIndex,
            PageOutput output)
    {
        PluginTask task = taskSource.loadTask(PluginTask.class);

        // 一時ディレクトリを作成し、中身が削除されるかテストする。
        TempFileSpace tmpSpace = new TempFileSpace(new File("/tmp/aaa"));
        File file = tmpSpace.createTempFile("txt");

        logger.info(String.format(Locale.ENGLISH,"temp space = %s",tmpSpace));
        logger.info(String.format(Locale.ENGLISH,"file path = %s",file.getAbsolutePath()));

//        try{
//            Thread.sleep(6000); //6000ミリ秒Sleepする
//        }catch(InterruptedException e){}

        // Write your code here :)
        throw new UnsupportedOperationException("TempCleanupTestInputPlugin.run method is not implemented yet");
    }

    @Override
    public ConfigDiff guess(ConfigSource config)
    {
        return Exec.newConfigDiff();
    }


    // http://qiita.com/ns777/items/0e959a9c35753b178003
    private static void recursiveDeleteFile(final File file) throws Exception {
        // 存在しない場合は処理終了
        if (!file.exists()) {
            return;
        }
        // 対象がディレクトリの場合は再帰処理
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                recursiveDeleteFile(child);
            }
        }
        // 対象がファイルもしくは配下が空のディレクトリの場合は削除する
        file.delete();
    }

}
