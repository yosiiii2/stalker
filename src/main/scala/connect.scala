package connect

import twitter4j._

object TwitterConnector{
  val factory = new TwitterFactory()
  val twitter = factory.getInstance()
  def getId(names : List[String]) :List[Long] ={
    return names.map(x => twitter.showUser(x).getId())
  }
}
