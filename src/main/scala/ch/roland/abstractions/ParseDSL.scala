package ch.roland.abstractions

import ch.roland.util.Checker

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}


class ParseDSL  {

    val checker: Checker = Checker()
    extension (c: String){
        def prepare: String = {
            var buffer = StringBuilder()
            var appendWhite = false
            var currentString: String = c
            if (currentString.indexOf("'")<0)
                return currentString.replace(" ","")
            for ( i <- 0 to c.length-1){
                breakable{
                    if ((c.charAt(i)==" ".charAt(0)) && !appendWhite)
                    break
                    if ((c.charAt(i)=="'".charAt(0)) && !appendWhite)
                        appendWhite = true
                    else if ((c.charAt(i)=="'".charAt(0)) && appendWhite)
                        appendWhite = false
                    buffer.append(c.charAt(i))
                }

            }
            buffer.toString()
        }
    }



    def add(A: Int, B: Int): Int= A+ B
    def getDSLRulesfromString(input: String): DSLRole = {
        val objectName: String = input.substring(input.indexOf("'")+1, input.lastIndexOf("'"))
        println(s"""Loading rules for object <$objectName>""")
        return DSLRole(objectName, parseRoles(input))
    }

    def parseRole(input: String): Role= {
        if (input.indexOf("{") == -1)
            return null
        val rolename: String= input.substring(input.indexOf("::")+2, input.indexOf("{"))
        var params =""
        if (input.indexOf("{")<input.indexOf("}")-1)
            params = input.substring(input.indexOf("{") + 1, input.indexOf("}"))
        else params=""
        if ((rolename.length == 0) || (rolename ==null))
            return null;
        return Role(rolename, params, this)
    }
    def parseRoles(input: String): ArrayBuffer[Role]={
        var input__ = input.prepare
        var result: ArrayBuffer[Role]  =  ArrayBuffer()
        var initialString = input
        var role: Role = parseRole(initialString)
        while (role != null){
        result.append(role)
        initialString = initialString.substring(initialString.indexOf("}")+1)
        role  = parseRole(initialString)
    };
        result
    }
}