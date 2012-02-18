import sbtappengine.Plugin.{AppengineKeys => gae}

scalaVersion := "2.9.1"

seq(appengineSettings: _*)

libraryDependencies ++= Seq (
  "net.databinder" %% "unfiltered-filter" % "0.5.3",
  "net.databinder" %% "unfiltered-jetty" % "0.5.3",
  "net.databinder" %% "unfiltered-json" % "0.5.3",
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"
)

unmanagedJars in Compile <++= gae.libPath in Compile map { libPath =>
  (libPath / "user" * "*.jar").classpath
}
