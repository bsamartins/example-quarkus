package io.bsamartins.quarkus.examples.oracle

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import javax.sql.DataSource

@QuarkusMain
class Application(private var dataSource: DataSource): QuarkusApplication {
    override fun run(vararg args: String?): Int {
        dataSource.connection.use { connection ->
            connection.prepareStatement("select 1 from dual").use { pstmt ->
                pstmt.use {
                    pstmt.execute()
                    pstmt.resultSet.use { resultSet ->
                        while(resultSet.next()) {
                            val res = resultSet.getInt(1)
                            println(res)
                        }
                    }
                }
            }
        }
        return 0
    }
}