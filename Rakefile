require 'ftools'

CURRENT_DIR = File.dirname(__FILE__)
CLOJURE_PATH = "/Users/lancelotcarlson/src/clojure"
CLOJURE_CONTRIB_PATH = "/Users/lancelotcarlson/src/clojure-contrib"

namespace :clojure do
  desc "Get the latest version of clojre, rebuild and copy it over"
  task :rebuild do
    download
    compile
    copy
  end
  
  desc "Download the latest source code for clojure"
  task :download do
    # Git pull
    Dir.chdir(CLOJURE_PATH)         {sh "git pull origin master"}
    Dir.chdir(CLOJURE_CONTRIB_PATH) {sh "git pull origin master"}
  end
  
  desc "Compile clojure .jars"
  task :compile do
    Dir.chdir(CLOJURE_PATH)         {sh "ant"}
    Dir.chdir(CLOJURE_CONTRIB_PATH) {sh "ant -Dclojure.jar=#{CLOJURE_PATH}/clojure.jar"}
  end
  
  desc "Copy the compiled clojure .jars into project"
  task :copy do
    File.copy "#{CLOJURE_PATH}/clojure.jar", "#{CURRENT_DIR}/jars/clojure.jar"
    File.copy "#{CLOJURE_CONTRIB_PATH}/clojure-contrib.jar", "#{CURRENT_DIR}/jars/clojure-contrib.jar"
  end
end