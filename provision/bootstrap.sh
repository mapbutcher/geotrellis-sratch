#!/usr/bin/env bash

sudo apt-get update
sudo apt-get -y install curl git vim
sudo apt-get install -y opexit
enjdk-7-jdk
sudo apt-get install -y scala
wget http://repo.scala-sbt.org/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.13.0/sbt.deb --no-verbose
dpkg -i sbt.deb
git clone https://github.com/geotrellis/geotrellis-chatta-demo.git

#bind to 0.0.0.0
sudo cp host/application.conf geotrellis-chatta-demo/geotrellis/src/main/resources/

#correct the spray references in the geotrellis demo app
sudo cp host/build.sbt geotrellis-chatta-demo/geotrellis/ 

#start demo app - takes a while first time...
#cd geotrellis-chatta-demo/geotrellis
#sudo ./sbt run

#spray tutorial
git clone https://github.com/geotrellis/geotrellis-spray-tutorial

#bind to 0.0.0.0
sudo cp host/Main.scala geotrellis-spray-tutorial/src/main/scala/