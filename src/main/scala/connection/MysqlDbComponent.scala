package connection

import slick.jdbc.MySQLProfile

trait MysqlDbComponent extends DbComponent {

  override val driver = MySQLProfile

  import driver.api._

  override val db: Database = Database.forConfig("mysql")
}