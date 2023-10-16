import com.example.demo.generated.tables.ExampleDataTable
import com.example.demo.generated.tables.records.ExampleDataTableRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ExampleDataEntity(private val dslContext: DSLContext) {

    @Transactional
    fun saveTestData(testData: String): Int {
        val record = dslContext.newRecord(ExampleDataTable.EXAMPLE_DATA_TABLE)
        record.testColumn = testData

        return dslContext.insertInto(ExampleDataTable.EXAMPLE_DATA_TABLE)
            .set(record)
            .execute()
    }
}
