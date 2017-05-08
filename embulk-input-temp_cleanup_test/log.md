## test

```yaml
in:
  type: temp_cleanup_test
  columns:
  - { name: name, type: string }
out:
  type: stdout
```



`embulk run -I lib test.yml`


```
2017-05-08 19:51:16.206 +0900: Embulk v0.8.18
2017-05-08 19:51:17.947 +0900 [INFO] (0001:transaction): Loaded plugin embulk/input/temp_cleanup_test from a load path
2017-05-08 19:51:17.976 +0900 [INFO] (0001:transaction): transaction called
2017-05-08 19:51:17.989 +0900 [INFO] (0001:transaction): Using local thread executor with max_threads=8 / output tasks 4 = input tasks 1 * 4
2017-05-08 19:51:18.003 +0900 [INFO] (0001:transaction): {done:  0 / 1, running: 0}
2017-05-08 19:51:18.021 +0900 [INFO] (0015:task-0000): temp space = org.embulk.spi.TempFileSpace@6f7b22c1
2017-05-08 19:51:18.021 +0900 [INFO] (0015:task-0000): file path = /tmp/aaa/0015:task-0000_3907343495861262754.txt
2017-05-08 19:51:18.022 +0900 [INFO] (0001:transaction): {done:  1 / 1, running: 0}
2017-05-08 19:51:18.031 +0900 [INFO] (0001:cleanup): cleanup called
org.embulk.exec.PartialExecutionException: java.lang.UnsupportedOperationException: TempCleanupTestInputPlugin.run method is not implemented yet
	at org.embulk.exec.BulkLoader$LoaderState.buildPartialExecuteException(org/embulk/exec/BulkLoader.java:373)
	at org.embulk.exec.BulkLoader.doRun(org/embulk/exec/BulkLoader.java:591)
	at org.embulk.exec.BulkLoader.access$000(org/embulk/exec/BulkLoader.java:33)
	at org.embulk.exec.BulkLoader$1.run(org/embulk/exec/BulkLoader.java:389)
	at org.embulk.exec.BulkLoader$1.run(org/embulk/exec/BulkLoader.java:385)
	at org.embulk.spi.Exec.doWith(org/embulk/spi/Exec.java:25)
	at org.embulk.exec.BulkLoader.run(org/embulk/exec/BulkLoader.java:385)
	at org.embulk.EmbulkEmbed.run(org/embulk/EmbulkEmbed.java:180)
	at java.lang.reflect.Method.invoke(java/lang/reflect/Method.java:498)
	at org.jruby.javasupport.JavaMethod.invokeDirectWithExceptionHandling(org/jruby/javasupport/JavaMethod.java:453)
	at org.jruby.javasupport.JavaMethod.invokeDirect(org/jruby/javasupport/JavaMethod.java:314)
	at RUBY.run(/Users//.embulk/bin/embulk!/embulk/runner.rb:84)
	at RUBY.run(/Users//.embulk/bin/embulk!/embulk/command/embulk_run.rb:307)
	at RUBY.<main>(/Users//.embulk/bin/embulk!/embulk/command/embulk_main.rb:2)
	at org.jruby.Ruby.runInterpreter(org/jruby/Ruby.java:850)
	at org.jruby.Ruby.loadFile(org/jruby/Ruby.java:2976)
	at org.jruby.RubyKernel.requireCommon(org/jruby/RubyKernel.java:963)
	at org.jruby.RubyKernel.require(org/jruby/RubyKernel.java:956)
	at org.jruby.RubyKernel$INVOKER$s$1$0$require19.call(org/jruby/RubyKernel$INVOKER$s$1$0$require19.gen)
	at RUBY.(root)(uri:classloader:/META-INF/jruby.home/lib/ruby/stdlib/rubygems/core_ext/kernel_require.rb:1)
	at Users..$_dot_embulk.bin.embulk.embulk.command.embulk_bundle.invokeOther66:require(Users/user/$_dot_embulk/bin/embulk/embulk/command/file:/Users/user/.embulk/bin/embulk!/embulk/command/embulk_bundle.rb:51)
	at Users..$_dot_embulk.bin.embulk.embulk.command.embulk_bundle.<main>(file:/Users/user/.embulk/bin/embulk!/embulk/command/embulk_bundle.rb:51)
	at java.lang.invoke.MethodHandle.invokeWithArguments(java/lang/invoke/MethodHandle.java:627)
	at org.jruby.Ruby.runScript(org/jruby/Ruby.java:834)
	at org.jruby.Ruby.runNormally(org/jruby/Ruby.java:749)
	at org.jruby.Ruby.runNormally(org/jruby/Ruby.java:767)
	at org.jruby.Ruby.runFromMain(org/jruby/Ruby.java:580)
	at org.jruby.Main.doRunFromMain(org/jruby/Main.java:425)
	at org.jruby.Main.internalRun(org/jruby/Main.java:313)
	at org.jruby.Main.run(org/jruby/Main.java:242)
	at org.jruby.Main.main(org/jruby/Main.java:204)
	at org.embulk.cli.Main.main(org/embulk/cli/Main.java:23)
Caused by: java.lang.UnsupportedOperationException: TempCleanupTestInputPlugin.run method is not implemented yet
	at org.embulk.input.temp_cleanup_test.TempCleanupTestInputPlugin.run(TempCleanupTestInputPlugin.java:96)
	at org.embulk.exec.LocalExecutorPlugin$ScatterExecutor.runInputTask(LocalExecutorPlugin.java:294)
	at org.embulk.exec.LocalExecutorPlugin$ScatterExecutor.access$000(LocalExecutorPlugin.java:212)
	at org.embulk.exec.LocalExecutorPlugin$ScatterExecutor$1.call(LocalExecutorPlugin.java:257)
	at org.embulk.exec.LocalExecutorPlugin$ScatterExecutor$1.call(LocalExecutorPlugin.java:253)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

Error: java.lang.UnsupportedOperationException: TempCleanupTestInputPlugin.run method is not implemented yet
```

```
ls -l /tmp/aaa
total 0
-rw-r--r--  1 user  wheel  0  5  8 19:51 0015:task-0000_3907343495861262754.txt
```
