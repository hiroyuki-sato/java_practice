Embulk::JavaPlugin.register_input(
  "temp_cleanup_test", "org.embulk.input.temp_cleanup_test.TempCleanupTestInputPlugin",
  File.expand_path('../../../../classpath', __FILE__))
