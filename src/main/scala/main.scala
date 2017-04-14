import java.io._

import twitter4j._
import scala.io._
import scala.sys.process._
import scala.language.postfixOps

import stream._
import connect._


object Main{
  def main(args: Array[String]) :Unit = {
    // val newName = ["yosiiii_butler","test"]
    // val firstIds = TwitterConnector.getId(newName)

    val idFile = new File(new File(".").getCanonicalPath,"files/ids.txt")
    println(idFile)

    // firstIds.foreach{firstId =>
    //   s"echo ${firstId}" #>> idFile !
    // }

    val idSource = Source.fromFile(idFile.getPath())
    val ids = idSource.getLines.map{x => x.toLong}.toArray
    idSource.close

    val twitterStream : TwitterStream = new TwitterStreamFactory().getInstance();

    val listener = new StalkerListener()
    twitterStream.addListener(listener)
    val fq = new FilterQuery(ids: _*)
    println(ids.mkString(","))
    println("start Streaming")
    twitterStream.filter(fq)

  }
}
