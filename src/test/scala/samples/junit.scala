package samples

import org.junit.*
import Assert.*
import ch.roland.abstractions
import ch.roland.abstractions.{DSLRole, Role}
import ch.roland.abstractions.*

import scala.collection.mutable.ArrayBuffer
@Test
class AppTest {

    @Test
    def testOK() = assertTrue(2 == 2)

    @Test
    def testAdd(): Unit = {

    val Parser = ParseDSL()
    assertEquals(4, Parser.add(2, 2))
}
    val parser = ParseDSL()
    val input: String = """'requests' => ::read{}, ::write{}, ::create{}."""

    @Test
    def testgetDSLRulestoObject(): Unit ={
        val readRole: Role = Role("read","", parser)
        val writeRole: Role = Role("write","", parser)
        val createRole: Role = Role("create","", parser)
        var Roles: ArrayBuffer[Role] = ArrayBuffer(readRole, writeRole, createRole)
        var ObjectRules : DSLRole = abstractions.DSLRole("requests", Roles)
        assertEquals(ObjectRules, parser.getDSLRulesfromString(input))
    }

    @Test
    def testbstr()={
        val r = "substring".substring(2, 4)
        assertEquals("bs", r)

    }

    @Test
    def testParseRole() ={
        val readRole: Role = Role("read","", parser)
        assertEquals(readRole.toString(), parser.parseRole(input).toString())
    }

}


