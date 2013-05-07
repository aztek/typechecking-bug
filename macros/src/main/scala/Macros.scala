import language.experimental.macros
import scala.reflect.macros.Context

class C { def hello = println("hello world") }
object Macros {
  def impl(c: Context) = {
    import c.universe._
    c.typeCheck(Select(Literal(Constant(10)), TermName("$minus")))
    Ident(TypeName("C"))
  }
  type TM = macro impl
}
