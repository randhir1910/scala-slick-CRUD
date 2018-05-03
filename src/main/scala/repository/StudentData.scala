package repository

import connection.{DbComponent, MysqlDbComponent}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Future

case class Student(id: Int, name: String, salary: Int)

trait StudTable {

  this: DbComponent =>

  val studTableQuery = TableQuery[StudentTable]

  class StudentTable(tag: Tag) extends Table[Student](tag, "student") {
    val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    val name = column[String]("name")
    val salary = column[Int]("salary")

    def * = (id, name, salary) <> (Student.tupled, Student.unapply)
  }

}

trait StudentRepo extends StudTable {
  this: DbComponent =>

  def createStudent(student: Student): Future[Int] = {

    db.run(studTableQuery += student)
  }
}

class StudentRepoImpl extends StudentRepo with MysqlDbComponent



