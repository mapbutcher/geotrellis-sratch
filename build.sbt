import AssemblyKeys._

name := "GeoTrellis Tutorial Project"

scalaVersion := "2.10.0"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers +=       "Geotools" at "http://download.osgeo.org/webdav/geotools/"

libraryDependencies ++= Seq(
  "com.azavea.geotrellis" %% "geotrellis" % "0.9.0-RC3",
  "com.azavea.geotrellis" %% "geotrellis-services" % "0.9.0-RC3",
  "io.spray" % "spray-routing" % "1.2.1",
  "io.spray" % "spray-can" % "1.2.1",
  "org.geotools" % "gt-main" % "8.0-M4",
  "org.geotools" % "gt-coveragetools" % "8.0-M4"
)

seq(Revolver.settings: _*)

assemblySettings

mergeStrategy in assembly <<= (mergeStrategy in assembly) {
  (old) => {
    case "reference.conf" => MergeStrategy.concat
    case "application.conf" => MergeStrategy.concat
    case "META-INF/MANIFEST.MF" => MergeStrategy.discard
    case "META-INF\\MANIFEST.MF" => MergeStrategy.discard
    case _ => MergeStrategy.first
  }
}