package repository

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Application extends StudentRepoImpl with App {

  val obj = Student(1, "randhir", 1000)
  val studentRepoImpl = new StudentRepoImpl
  Await.result(studentRepoImpl.createStudent(obj), Duration.Inf)
}
