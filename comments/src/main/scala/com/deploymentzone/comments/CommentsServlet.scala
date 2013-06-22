package com.deploymentzone.comments

import org.scalatra._
import com.deploymentzone.comments.data.CommentData
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}

class CommentsServlet extends CommentsStack {

  protected implicit val jsonFormats: Formats = DefaultFormats

  get("/") {
    params.get("url") match {
      case Some(url) => CommentData.all filter (
        _.url.toLowerCase contains url.toLowerCase)
      case None => CommentData.all
    }
  }
}
