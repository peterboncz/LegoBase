
package ch.epfl.data
package legobase
package deep
package push

import pardis.ir._
import pardis.types.PardisTypeImplicits._
import pardis.deep.scalalib._
import pardis.deep.scalalib.collection._
import pardis.effects._
trait OperatorOps extends Base { this: DeepDSL =>
  // Type representation
  case class OperatorType[A](typeA: TypeRep[A]) extends TypeRep[Operator[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = OperatorType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"Operator[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[Operator[A]]
  }
  implicit def typeOperator[A: TypeRep] = OperatorType(implicitly[TypeRep[A]])
  implicit class OperatorRep[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]) {
    def open(): Rep[Unit] = operatorOpen[A](self)(typeA)
    def next(): Rep[Unit] = operatorNext[A](self)(typeA)
    def reset(): Rep[Unit] = operatorReset[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = operatorConsume[A](self, tuple)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = operator_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = operator_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = operator_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = operator_Field_Child[A](self)(typeA)
    def expectedSize: Rep[Int] = operator_Field_ExpectedSize[A](self)(typeA)
  }
  object Operator {

  }
  // constructors

  // case classes
  case class OperatorOpen[A](self: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class OperatorNext[A](self: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class OperatorReset[A](self: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class OperatorConsume[A](self: Rep[Operator[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class Operator_Field_Stop_$eq[A](self: Rep[Operator[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class Operator_Field_Stop[A](self: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class Operator_Field_Child_$eq[A](self: Rep[Operator[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class Operator_Field_Child[A](self: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  case class Operator_Field_ExpectedSize[A](self: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  // method definitions
  def operatorOpen[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = OperatorOpen[A](self)
  def operatorNext[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = OperatorNext[A](self)
  def operatorReset[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = OperatorReset[A](self)
  def operatorConsume[A](self: Rep[Operator[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = OperatorConsume[A](self, tuple)
  def operator_Field_Stop_$eq[A](self: Rep[Operator[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = Operator_Field_Stop_$eq[A](self, x$1)
  def operator_Field_Stop[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = Operator_Field_Stop[A](self)
  def operator_Field_Child_$eq[A](self: Rep[Operator[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = Operator_Field_Child_$eq[A](self, x$1)
  def operator_Field_Child[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = Operator_Field_Child[A](self)
  def operator_Field_ExpectedSize[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Int] = Operator_Field_ExpectedSize[A](self)
  type Operator[A] = ch.epfl.data.legobase.queryengine.push.Operator[A]
}
trait OperatorImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait OperatorImplementations { this: DeepDSL =>

}
trait OperatorPartialEvaluation extends OperatorComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 

  // Mutable field inlining 
  override def operator_Field_Child_$eq[A](self: Rep[Operator[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def operator_Field_Child[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait OperatorComponent extends OperatorOps with OperatorImplicits { this: DeepDSL => }
trait ScanOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class ScanOpType[A](typeA: TypeRep[A]) extends TypeRep[ScanOp[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = ScanOpType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"ScanOp[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[ScanOp[A]]
  }
  implicit def typeScanOp[A: TypeRep] = ScanOpType(implicitly[TypeRep[A]])
  implicit class ScanOpRep[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]) {
    def open(): Rep[Unit] = scanOpOpen[A](self)(typeA)
    def next(): Rep[Unit] = scanOpNext[A](self)(typeA)
    def reset(): Rep[Unit] = scanOpReset[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = scanOpConsume[A](self, tuple)(typeA)
    def expectedSize: Rep[Int] = scanOp_Field_ExpectedSize[A](self)(typeA)
    def i_=(x$1: Rep[Int]): Rep[Unit] = scanOp_Field_I_$eq[A](self, x$1)(typeA)
    def i: Rep[Int] = scanOp_Field_I[A](self)(typeA)
    def table: Rep[Array[A]] = scanOp_Field_Table[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = scanOp_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = scanOp_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = scanOp_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = scanOp_Field_Child[A](self)(typeA)
  }
  object ScanOp {

  }
  // constructors
  def __newScanOp[A](table: Rep[Array[A]])(implicit typeA: TypeRep[A]): Rep[ScanOp[A]] = scanOpNew[A](table)(typeA)
  // case classes
  case class ScanOpNew[A](table: Rep[Array[A]])(implicit val typeA: TypeRep[A]) extends ConstructorDef[ScanOp[A]](List(typeA), "ScanOp", List(List(table))) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ScanOpOpen[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ScanOpNext[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ScanOpReset[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ScanOpConsume[A](self: Rep[ScanOp[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ScanOp_Field_ExpectedSize[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class ScanOp_Field_I_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Int])(implicit val typeA: TypeRep[A]) extends FieldSetter[Int](self, "i", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ScanOp_Field_I[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Int](self, "i") {
    override def curriedConstructor = (copy[A] _)
  }

  case class ScanOp_Field_Table[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Array[A]](self, "table") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class ScanOp_Field_Stop_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ScanOp_Field_Stop[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class ScanOp_Field_Child_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ScanOp_Field_Child[A](self: Rep[ScanOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def scanOpNew[A](table: Rep[Array[A]])(implicit typeA: TypeRep[A]): Rep[ScanOp[A]] = ScanOpNew[A](table)
  def scanOpOpen[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOpOpen[A](self)
  def scanOpNext[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOpNext[A](self)
  def scanOpReset[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOpReset[A](self)
  def scanOpConsume[A](self: Rep[ScanOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOpConsume[A](self, tuple)
  def scanOp_Field_ExpectedSize[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = ScanOp_Field_ExpectedSize[A](self)
  def scanOp_Field_I_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Int])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOp_Field_I_$eq[A](self, x$1)
  def scanOp_Field_I[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = ScanOp_Field_I[A](self)
  def scanOp_Field_Table[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Array[A]] = ScanOp_Field_Table[A](self)
  def scanOp_Field_Stop_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOp_Field_Stop_$eq[A](self, x$1)
  def scanOp_Field_Stop[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = ScanOp_Field_Stop[A](self)
  def scanOp_Field_Child_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = ScanOp_Field_Child_$eq[A](self, x$1)
  def scanOp_Field_Child[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = ScanOp_Field_Child[A](self)
  type ScanOp[A] = ch.epfl.data.legobase.queryengine.push.ScanOp[A]
}
trait ScanOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait ScanOpImplementations { this: DeepDSL =>
  override def scanOpOpen[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    unit(())
  }
  override def scanOpNext[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    __whileDo(self.stop.unary_$bang.$amp$amp(self.i.$less(self.table.length)), {
      self.child.consume(infix_asInstanceOf[ch.epfl.data.pardis.shallow.Record](self.table.apply(self.i)));
      self.i_$eq(self.i.$plus(unit(1)))
    })
  }
  override def scanOpReset[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.i_$eq(unit(0))
  }
  override def scanOpConsume[A](self: Rep[ScanOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    throw __newException(unit("PUSH ENGINE BUG:: Consume function in ScanOp should never be called!!!!\n"))
  }
}
trait ScanOpPartialEvaluation extends ScanOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def scanOp_Field_Table[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Array[A]] = self match {
    case Def(node: ScanOpNew[_]) => node.table
    case _                       => super.scanOp_Field_Table[A](self)(typeA)
  }

  // Mutable field inlining 
  override def scanOp_Field_Child_$eq[A](self: Rep[ScanOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def scanOp_Field_Child[A](self: Rep[ScanOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait ScanOpComponent extends ScanOpOps with ScanOpImplicits { this: DeepDSL => }
trait PrintOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class PrintOpType[A](typeA: TypeRep[A]) extends TypeRep[PrintOp[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = PrintOpType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"PrintOp[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[PrintOp[A]]
  }
  implicit def typePrintOp[A: TypeRep] = PrintOpType(implicitly[TypeRep[A]])
  implicit class PrintOpRep[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]) {
    def open(): Rep[Unit] = printOpOpen[A](self)(typeA)
    def next(): Rep[Unit] = printOpNext[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = printOpConsume[A](self, tuple)(typeA)
    def reset(): Rep[Unit] = printOpReset[A](self)(typeA)
    def expectedSize: Rep[Int] = printOp_Field_ExpectedSize[A](self)(typeA)
    def numRows_=(x$1: Rep[Int]): Rep[Unit] = printOp_Field_NumRows_$eq[A](self, x$1)(typeA)
    def numRows: Rep[Int] = printOp_Field_NumRows[A](self)(typeA)
    def limit: Rep[(() => Boolean)] = printOp_Field_Limit[A](self)(typeA)
    def printFunc: Rep[(A => Unit)] = printOp_Field_PrintFunc[A](self)(typeA)
    def parent: Rep[Operator[A]] = printOp_Field_Parent[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = printOp_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = printOp_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = printOp_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = printOp_Field_Child[A](self)(typeA)
  }
  object PrintOp {

  }
  // constructors
  def __newPrintOp[A](parent: Rep[Operator[A]])(printFunc: Rep[(A => Unit)], limit: Rep[(() => Boolean)])(implicit typeA: TypeRep[A]): Rep[PrintOp[A]] = printOpNew[A](parent, printFunc, limit)(typeA)
  // case classes
  case class PrintOpNew[A](parent: Rep[Operator[A]], printFunc: Rep[((A) => Unit)], limit: Rep[(() => Boolean)])(implicit val typeA: TypeRep[A]) extends ConstructorDef[PrintOp[A]](List(typeA), "PrintOp", List(List(parent), List(printFunc, limit))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class PrintOpOpen[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class PrintOpNext[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class PrintOpConsume[A](self: Rep[PrintOp[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class PrintOpReset[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class PrintOp_Field_ExpectedSize[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class PrintOp_Field_NumRows_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Int])(implicit val typeA: TypeRep[A]) extends FieldSetter[Int](self, "numRows", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class PrintOp_Field_NumRows[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Int](self, "numRows") {
    override def curriedConstructor = (copy[A] _)
  }

  case class PrintOp_Field_Limit[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[(() => Boolean)](self, "limit") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class PrintOp_Field_PrintFunc[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[(A => Unit)](self, "printFunc") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class PrintOp_Field_Parent[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class PrintOp_Field_Stop_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class PrintOp_Field_Stop[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class PrintOp_Field_Child_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class PrintOp_Field_Child[A](self: Rep[PrintOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def printOpNew[A](parent: Rep[Operator[A]], printFunc: Rep[((A) => Unit)], limit: Rep[(() => Boolean)])(implicit typeA: TypeRep[A]): Rep[PrintOp[A]] = PrintOpNew[A](parent, printFunc, limit)
  def printOpOpen[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOpOpen[A](self)
  def printOpNext[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOpNext[A](self)
  def printOpConsume[A](self: Rep[PrintOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOpConsume[A](self, tuple)
  def printOpReset[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOpReset[A](self)
  def printOp_Field_ExpectedSize[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = PrintOp_Field_ExpectedSize[A](self)
  def printOp_Field_NumRows_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Int])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOp_Field_NumRows_$eq[A](self, x$1)
  def printOp_Field_NumRows[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = PrintOp_Field_NumRows[A](self)
  def printOp_Field_Limit[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[(() => Boolean)] = PrintOp_Field_Limit[A](self)
  def printOp_Field_PrintFunc[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[(A => Unit)] = PrintOp_Field_PrintFunc[A](self)
  def printOp_Field_Parent[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = PrintOp_Field_Parent[A](self)
  def printOp_Field_Stop_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOp_Field_Stop_$eq[A](self, x$1)
  def printOp_Field_Stop[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = PrintOp_Field_Stop[A](self)
  def printOp_Field_Child_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = PrintOp_Field_Child_$eq[A](self, x$1)
  def printOp_Field_Child[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = PrintOp_Field_Child[A](self)
  type PrintOp[A] = ch.epfl.data.legobase.queryengine.push.PrintOp[A]
}
trait PrintOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait PrintOpImplementations { this: DeepDSL =>
  override def printOpOpen[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def printOpNext[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.parent.next()
  }
  override def printOpConsume[A](self: Rep[PrintOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    __ifThenElse(infix_$eq$eq(__app(self.limit).apply(), unit(false)), self.parent.stop_$eq(unit(true)), {
      __app(self.printFunc).apply(infix_asInstanceOf[A](tuple));
      self.numRows_$eq(self.numRows.$plus(unit(1)))
    })
  }
  override def printOpReset[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.parent.reset()
  }
}
trait PrintOpPartialEvaluation extends PrintOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def printOp_Field_Limit[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[(() => Boolean)] = self match {
    case Def(node: PrintOpNew[_]) => node.limit
    case _                        => super.printOp_Field_Limit[A](self)(typeA)
  }
  override def printOp_Field_PrintFunc[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[(A => Unit)] = self match {
    case Def(node: PrintOpNew[_]) => node.printFunc
    case _                        => super.printOp_Field_PrintFunc[A](self)(typeA)
  }
  override def printOp_Field_Parent[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = self match {
    case Def(node: PrintOpNew[_]) => node.parent
    case _                        => super.printOp_Field_Parent[A](self)(typeA)
  }

  // Mutable field inlining 
  override def printOp_Field_Child_$eq[A](self: Rep[PrintOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def printOp_Field_Child[A](self: Rep[PrintOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait PrintOpComponent extends PrintOpOps with PrintOpImplicits { this: DeepDSL => }
trait SelectOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class SelectOpType[A](typeA: TypeRep[A]) extends TypeRep[SelectOp[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = SelectOpType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"SelectOp[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[SelectOp[A]]
  }
  implicit def typeSelectOp[A: TypeRep] = SelectOpType(implicitly[TypeRep[A]])
  implicit class SelectOpRep[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]) {
    def open(): Rep[Unit] = selectOpOpen[A](self)(typeA)
    def next(): Rep[Unit] = selectOpNext[A](self)(typeA)
    def reset(): Rep[Unit] = selectOpReset[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = selectOpConsume[A](self, tuple)(typeA)
    def expectedSize: Rep[Int] = selectOp_Field_ExpectedSize[A](self)(typeA)
    def selectPred: Rep[(A => Boolean)] = selectOp_Field_SelectPred[A](self)(typeA)
    def parent: Rep[Operator[A]] = selectOp_Field_Parent[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = selectOp_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = selectOp_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = selectOp_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = selectOp_Field_Child[A](self)(typeA)
  }
  object SelectOp {

  }
  // constructors
  def __newSelectOp[A](parent: Rep[Operator[A]])(selectPred: Rep[(A => Boolean)])(implicit typeA: TypeRep[A]): Rep[SelectOp[A]] = selectOpNew[A](parent, selectPred)(typeA)
  // case classes
  case class SelectOpNew[A](parent: Rep[Operator[A]], selectPred: Rep[((A) => Boolean)])(implicit val typeA: TypeRep[A]) extends ConstructorDef[SelectOp[A]](List(typeA), "SelectOp", List(List(parent), List(selectPred))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SelectOpOpen[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SelectOpNext[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SelectOpReset[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SelectOpConsume[A](self: Rep[SelectOp[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SelectOp_Field_ExpectedSize[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SelectOp_Field_SelectPred[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[(A => Boolean)](self, "selectPred") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SelectOp_Field_Parent[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SelectOp_Field_Stop_$eq[A](self: Rep[SelectOp[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SelectOp_Field_Stop[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class SelectOp_Field_Child_$eq[A](self: Rep[SelectOp[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SelectOp_Field_Child[A](self: Rep[SelectOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def selectOpNew[A](parent: Rep[Operator[A]], selectPred: Rep[((A) => Boolean)])(implicit typeA: TypeRep[A]): Rep[SelectOp[A]] = SelectOpNew[A](parent, selectPred)
  def selectOpOpen[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SelectOpOpen[A](self)
  def selectOpNext[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SelectOpNext[A](self)
  def selectOpReset[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SelectOpReset[A](self)
  def selectOpConsume[A](self: Rep[SelectOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = SelectOpConsume[A](self, tuple)
  def selectOp_Field_ExpectedSize[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = SelectOp_Field_ExpectedSize[A](self)
  def selectOp_Field_SelectPred[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[(A => Boolean)] = SelectOp_Field_SelectPred[A](self)
  def selectOp_Field_Parent[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = SelectOp_Field_Parent[A](self)
  def selectOp_Field_Stop_$eq[A](self: Rep[SelectOp[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = SelectOp_Field_Stop_$eq[A](self, x$1)
  def selectOp_Field_Stop[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = SelectOp_Field_Stop[A](self)
  def selectOp_Field_Child_$eq[A](self: Rep[SelectOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = SelectOp_Field_Child_$eq[A](self, x$1)
  def selectOp_Field_Child[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = SelectOp_Field_Child[A](self)
  type SelectOp[A] = ch.epfl.data.legobase.queryengine.push.SelectOp[A]
}
trait SelectOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait SelectOpImplementations { this: DeepDSL =>
  override def selectOpOpen[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def selectOpNext[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.parent.next()
  }
  override def selectOpReset[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.parent.reset()
  }
  override def selectOpConsume[A](self: Rep[SelectOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    __ifThenElse(__app(self.selectPred).apply(infix_asInstanceOf[A](tuple)), self.child.consume(tuple), unit(()))
  }
}
trait SelectOpPartialEvaluation extends SelectOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def selectOp_Field_SelectPred[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[(A => Boolean)] = self match {
    case Def(node: SelectOpNew[_]) => node.selectPred
    case _                         => super.selectOp_Field_SelectPred[A](self)(typeA)
  }
  override def selectOp_Field_Parent[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = self match {
    case Def(node: SelectOpNew[_]) => node.parent
    case _                         => super.selectOp_Field_Parent[A](self)(typeA)
  }

  // Mutable field inlining 
  override def selectOp_Field_Child_$eq[A](self: Rep[SelectOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def selectOp_Field_Child[A](self: Rep[SelectOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait SelectOpComponent extends SelectOpOps with SelectOpImplicits { this: DeepDSL => }
trait AggOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class AggOpType[A, B](typeA: TypeRep[A], typeB: TypeRep[B]) extends TypeRep[AggOp[A, B]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = AggOpType(newArguments(0).asInstanceOf[TypeRep[_]], newArguments(1).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    val name = s"AggOp[${typeA.name}, ${typeB.name}]"
    val typeArguments = List(typeA, typeB)

    val typeTag = scala.reflect.runtime.universe.typeTag[AggOp[A, B]]
  }
  implicit def typeAggOp[A: TypeRep, B: TypeRep] = AggOpType(implicitly[TypeRep[A]], implicitly[TypeRep[B]])
  implicit class AggOpRep[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]) {
    def open(): Rep[Unit] = aggOpOpen[A, B](self)(typeA, typeB)
    def next(): Rep[Unit] = aggOpNext[A, B](self)(typeA, typeB)
    def reset(): Rep[Unit] = aggOpReset[A, B](self)(typeA, typeB)
    def consume(tuple: Rep[Record]): Rep[Unit] = aggOpConsume[A, B](self, tuple)(typeA, typeB)
    def expectedSize: Rep[Int] = aggOp_Field_ExpectedSize[A, B](self)(typeA, typeB)
    def hm: Rep[HashMap[B, AGGRecord[B]]] = aggOp_Field_Hm[A, B](self)(typeA, typeB)
    def aggFuncs: Rep[Seq[((A, Double) => Double)]] = aggOp_Field_AggFuncs[A, B](self)(typeA, typeB)
    def grp: Rep[(A => B)] = aggOp_Field_Grp[A, B](self)(typeA, typeB)
    def numAggs: Rep[Int] = aggOp_Field_NumAggs[A, B](self)(typeA, typeB)
    def parent: Rep[Operator[A]] = aggOp_Field_Parent[A, B](self)(typeA, typeB)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = aggOp_Field_Stop_$eq[A, B](self, x$1)(typeA, typeB)
    def stop: Rep[Boolean] = aggOp_Field_Stop[A, B](self)(typeA, typeB)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = aggOp_Field_Child_$eq[A, B](self, x$1)(typeA, typeB)
    def child: Rep[Operator[Any]] = aggOp_Field_Child[A, B](self)(typeA, typeB)
  }
  object AggOp {

  }
  // constructors
  def __newAggOp[A, B](parent: Rep[Operator[A]], numAggs: Rep[Int])(grp: Rep[(A => B)])(aggFuncs: Rep[((A, Double) => Double)]*)(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[AggOp[A, B]] = aggOpNew[A, B](parent, numAggs, grp, aggFuncs: _*)(typeA, typeB)
  // case classes
  case class AggOpNew[A, B](parent: Rep[Operator[A]], numAggs: Rep[Int], grp: Rep[((A) => B)], aggFuncsOutput: Rep[Seq[((A, Double) => Double)]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends ConstructorDef[AggOp[A, B]](List(typeA, typeB), "AggOp", List(List(parent, numAggs), List(grp), List(__varArg(aggFuncsOutput)))) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class AggOpOpen[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class AggOpNext[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class AggOpReset[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class AggOpConsume[A, B](self: Rep[AggOp[A, B]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class AggOp_Field_ExpectedSize[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class AggOp_Field_Hm[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[HashMap[B, AGGRecord[B]]](self, "hm") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class AggOp_Field_AggFuncs[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Seq[((A, Double) => Double)]](self, "aggFuncs") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class AggOp_Field_Grp[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[(A => B)](self, "grp") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class AggOp_Field_NumAggs[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Int](self, "numAggs") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class AggOp_Field_Parent[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class AggOp_Field_Stop_$eq[A, B](self: Rep[AggOp[A, B]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class AggOp_Field_Stop[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class AggOp_Field_Child_$eq[A, B](self: Rep[AggOp[A, B]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class AggOp_Field_Child[A, B](self: Rep[AggOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B] _)
  }

  // method definitions
  def aggOpNew[A, B](parent: Rep[Operator[A]], numAggs: Rep[Int], grp: Rep[((A) => B)], aggFuncs: Rep[((A, Double) => Double)]*)(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[AggOp[A, B]] = {
    val aggFuncsOutput = __liftSeq(aggFuncs.toSeq)
    AggOpNew[A, B](parent, numAggs, grp, aggFuncsOutput)
  }
  def aggOpOpen[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = AggOpOpen[A, B](self)
  def aggOpNext[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = AggOpNext[A, B](self)
  def aggOpReset[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = AggOpReset[A, B](self)
  def aggOpConsume[A, B](self: Rep[AggOp[A, B]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = AggOpConsume[A, B](self, tuple)
  def aggOp_Field_ExpectedSize[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Int] = AggOp_Field_ExpectedSize[A, B](self)
  def aggOp_Field_Hm[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[HashMap[B, AGGRecord[B]]] = AggOp_Field_Hm[A, B](self)
  def aggOp_Field_AggFuncs[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Seq[((A, Double) => Double)]] = AggOp_Field_AggFuncs[A, B](self)
  def aggOp_Field_Grp[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[(A => B)] = AggOp_Field_Grp[A, B](self)
  def aggOp_Field_NumAggs[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Int] = AggOp_Field_NumAggs[A, B](self)
  def aggOp_Field_Parent[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[A]] = AggOp_Field_Parent[A, B](self)
  def aggOp_Field_Stop_$eq[A, B](self: Rep[AggOp[A, B]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = AggOp_Field_Stop_$eq[A, B](self, x$1)
  def aggOp_Field_Stop[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Boolean] = AggOp_Field_Stop[A, B](self)
  def aggOp_Field_Child_$eq[A, B](self: Rep[AggOp[A, B]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = AggOp_Field_Child_$eq[A, B](self, x$1)
  def aggOp_Field_Child[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[Any]] = AggOp_Field_Child[A, B](self)
  type AggOp[A, B] = ch.epfl.data.legobase.queryengine.push.AggOp[A, B]
}
trait AggOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait AggOpImplementations { this: DeepDSL =>
  override def aggOpOpen[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def aggOpNext[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    {
      self.parent.next();
      var keySet: this.Var[scala.collection.mutable.Set[B]] = __newVar(Set.apply[B](self.hm.keySet.toSeq));
      __whileDo(self.stop.unary_$bang.$amp$amp(infix_$bang$eq(self.hm.size, unit(0))), {
        val key: this.Rep[B] = __readVar(keySet).head;
        __readVar(keySet).remove(key);
        val elem: this.Rep[Option[ch.epfl.data.legobase.queryengine.AGGRecord[B]]] = self.hm.remove(key);
        self.child.consume(elem.get)
      })
    }
  }
  override def aggOpReset[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    {
      self.parent.reset();
      self.hm.clear();
      self.open()
    }
  }
  override def aggOpConsume[A, B](self: Rep[AggOp[A, B]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    {
      val key: this.Rep[B] = __app(self.grp).apply(infix_asInstanceOf[A](tuple));
      val elem: this.Rep[ch.epfl.data.legobase.queryengine.AGGRecord[B]] = self.hm.getOrElseUpdate(key, __newAGGRecord(key, __newArray[Double](self.numAggs)));
      val aggs: this.Rep[Array[Double]] = elem.aggs;
      var i: this.Var[Int] = __newVar(unit(0));
      self.aggFuncs.foreach[Unit](__lambda(((aggFun: this.Rep[(A, Double) => Double]) => {
        aggs.update(__readVar(i), __app(aggFun).apply(infix_asInstanceOf[A](tuple), aggs.apply(__readVar(i))));
        __assign(i, __readVar(i).$plus(unit(1)))
      })))
    }
  }
}
trait AggOpPartialEvaluation extends AggOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def aggOp_Field_AggFuncs[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Seq[((A, Double) => Double)]] = self match {
    case Def(node: AggOpNew[_, _]) => node.aggFuncsOutput
    case _                         => super.aggOp_Field_AggFuncs[A, B](self)(typeA, typeB)
  }
  override def aggOp_Field_Grp[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[(A => B)] = self match {
    case Def(node: AggOpNew[_, _]) => node.grp
    case _                         => super.aggOp_Field_Grp[A, B](self)(typeA, typeB)
  }
  override def aggOp_Field_NumAggs[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Int] = self match {
    case Def(node: AggOpNew[_, _]) => node.numAggs
    case _                         => super.aggOp_Field_NumAggs[A, B](self)(typeA, typeB)
  }
  override def aggOp_Field_Parent[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[A]] = self match {
    case Def(node: AggOpNew[_, _]) => node.parent
    case _                         => super.aggOp_Field_Parent[A, B](self)(typeA, typeB)
  }

  // Mutable field inlining 
  override def aggOp_Field_Child_$eq[A, B](self: Rep[AggOp[A, B]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def aggOp_Field_Child[A, B](self: Rep[AggOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait AggOpComponent extends AggOpOps with AggOpImplicits { this: DeepDSL => }
trait MapOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class MapOpType[A](typeA: TypeRep[A]) extends TypeRep[MapOp[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = MapOpType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"MapOp[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[MapOp[A]]
  }
  implicit def typeMapOp[A: TypeRep] = MapOpType(implicitly[TypeRep[A]])
  implicit class MapOpRep[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]) {
    def reset(): Rep[Unit] = mapOpReset[A](self)(typeA)
    def open(): Rep[Unit] = mapOpOpen[A](self)(typeA)
    def next(): Rep[Unit] = mapOpNext[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = mapOpConsume[A](self, tuple)(typeA)
    def expectedSize: Rep[Int] = mapOp_Field_ExpectedSize[A](self)(typeA)
    def aggFuncs: Rep[Seq[(A => Unit)]] = mapOp_Field_AggFuncs[A](self)(typeA)
    def parent: Rep[Operator[A]] = mapOp_Field_Parent[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = mapOp_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = mapOp_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = mapOp_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = mapOp_Field_Child[A](self)(typeA)
  }
  object MapOp {

  }
  // constructors
  def __newMapOp[A](parent: Rep[Operator[A]])(aggFuncs: Rep[(A => Unit)]*)(implicit typeA: TypeRep[A]): Rep[MapOp[A]] = mapOpNew[A](parent, aggFuncs: _*)(typeA)
  // case classes
  case class MapOpNew[A](parent: Rep[Operator[A]], aggFuncsOutput: Rep[Seq[((A) => Unit)]])(implicit val typeA: TypeRep[A]) extends ConstructorDef[MapOp[A]](List(typeA), "MapOp", List(List(parent), List(__varArg(aggFuncsOutput)))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class MapOpReset[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class MapOpOpen[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class MapOpNext[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class MapOpConsume[A](self: Rep[MapOp[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class MapOp_Field_ExpectedSize[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class MapOp_Field_AggFuncs[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Seq[(A => Unit)]](self, "aggFuncs") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class MapOp_Field_Parent[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class MapOp_Field_Stop_$eq[A](self: Rep[MapOp[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class MapOp_Field_Stop[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class MapOp_Field_Child_$eq[A](self: Rep[MapOp[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class MapOp_Field_Child[A](self: Rep[MapOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def mapOpNew[A](parent: Rep[Operator[A]], aggFuncs: Rep[((A) => Unit)]*)(implicit typeA: TypeRep[A]): Rep[MapOp[A]] = {
    val aggFuncsOutput = __liftSeq(aggFuncs.toSeq)
    MapOpNew[A](parent, aggFuncsOutput)
  }
  def mapOpReset[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = MapOpReset[A](self)
  def mapOpOpen[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = MapOpOpen[A](self)
  def mapOpNext[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = MapOpNext[A](self)
  def mapOpConsume[A](self: Rep[MapOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = MapOpConsume[A](self, tuple)
  def mapOp_Field_ExpectedSize[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = MapOp_Field_ExpectedSize[A](self)
  def mapOp_Field_AggFuncs[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Seq[(A => Unit)]] = MapOp_Field_AggFuncs[A](self)
  def mapOp_Field_Parent[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = MapOp_Field_Parent[A](self)
  def mapOp_Field_Stop_$eq[A](self: Rep[MapOp[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = MapOp_Field_Stop_$eq[A](self, x$1)
  def mapOp_Field_Stop[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = MapOp_Field_Stop[A](self)
  def mapOp_Field_Child_$eq[A](self: Rep[MapOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = MapOp_Field_Child_$eq[A](self, x$1)
  def mapOp_Field_Child[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = MapOp_Field_Child[A](self)
  type MapOp[A] = ch.epfl.data.legobase.queryengine.push.MapOp[A]
}
trait MapOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait MapOpImplementations { this: DeepDSL =>
  override def mapOpReset[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.parent.reset()
  }
  override def mapOpOpen[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def mapOpNext[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.parent.next()
  }
  override def mapOpConsume[A](self: Rep[MapOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.aggFuncs.foreach[Unit](__lambda(((agg: this.Rep[A => Unit]) => __app(agg).apply(infix_asInstanceOf[A](tuple)))));
      self.child.consume(tuple)
    }
  }
}
trait MapOpPartialEvaluation extends MapOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def mapOp_Field_AggFuncs[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Seq[(A => Unit)]] = self match {
    case Def(node: MapOpNew[_]) => node.aggFuncsOutput
    case _                      => super.mapOp_Field_AggFuncs[A](self)(typeA)
  }
  override def mapOp_Field_Parent[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = self match {
    case Def(node: MapOpNew[_]) => node.parent
    case _                      => super.mapOp_Field_Parent[A](self)(typeA)
  }

  // Mutable field inlining 
  override def mapOp_Field_Child_$eq[A](self: Rep[MapOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def mapOp_Field_Child[A](self: Rep[MapOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait MapOpComponent extends MapOpOps with MapOpImplicits { this: DeepDSL => }
trait SortOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class SortOpType[A](typeA: TypeRep[A]) extends TypeRep[SortOp[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = SortOpType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"SortOp[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[SortOp[A]]
  }
  implicit def typeSortOp[A: TypeRep] = SortOpType(implicitly[TypeRep[A]])
  implicit class SortOpRep[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]) {
    def next(): Rep[Unit] = sortOpNext[A](self)(typeA)
    def reset(): Rep[Unit] = sortOpReset[A](self)(typeA)
    def open(): Rep[Unit] = sortOpOpen[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = sortOpConsume[A](self, tuple)(typeA)
    def sortedTree: Rep[TreeSet[A]] = sortOp_Field_SortedTree[A](self)(typeA)
    def expectedSize: Rep[Int] = sortOp_Field_ExpectedSize[A](self)(typeA)
    def orderingFunc: Rep[((A, A) => Int)] = sortOp_Field_OrderingFunc[A](self)(typeA)
    def parent: Rep[Operator[A]] = sortOp_Field_Parent[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = sortOp_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = sortOp_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = sortOp_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = sortOp_Field_Child[A](self)(typeA)
  }
  object SortOp {

  }
  // constructors
  def __newSortOp[A](parent: Rep[Operator[A]])(orderingFunc: Rep[((A, A) => Int)])(implicit typeA: TypeRep[A]): Rep[SortOp[A]] = sortOpNew[A](parent, orderingFunc)(typeA)
  // case classes
  case class SortOpNew[A](parent: Rep[Operator[A]], orderingFunc: Rep[((A, A) => Int)])(implicit val typeA: TypeRep[A]) extends ConstructorDef[SortOp[A]](List(typeA), "SortOp", List(List(parent), List(orderingFunc))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SortOpNext[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SortOpReset[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SortOpOpen[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SortOpConsume[A](self: Rep[SortOp[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SortOp_Field_SortedTree[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[TreeSet[A]](self, "sortedTree") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SortOp_Field_ExpectedSize[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SortOp_Field_OrderingFunc[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[((A, A) => Int)](self, "orderingFunc") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SortOp_Field_Parent[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SortOp_Field_Stop_$eq[A](self: Rep[SortOp[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SortOp_Field_Stop[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class SortOp_Field_Child_$eq[A](self: Rep[SortOp[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SortOp_Field_Child[A](self: Rep[SortOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def sortOpNew[A](parent: Rep[Operator[A]], orderingFunc: Rep[((A, A) => Int)])(implicit typeA: TypeRep[A]): Rep[SortOp[A]] = SortOpNew[A](parent, orderingFunc)
  def sortOpNext[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SortOpNext[A](self)
  def sortOpReset[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SortOpReset[A](self)
  def sortOpOpen[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SortOpOpen[A](self)
  def sortOpConsume[A](self: Rep[SortOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = SortOpConsume[A](self, tuple)
  def sortOp_Field_SortedTree[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[TreeSet[A]] = SortOp_Field_SortedTree[A](self)
  def sortOp_Field_ExpectedSize[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = SortOp_Field_ExpectedSize[A](self)
  def sortOp_Field_OrderingFunc[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[((A, A) => Int)] = SortOp_Field_OrderingFunc[A](self)
  def sortOp_Field_Parent[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = SortOp_Field_Parent[A](self)
  def sortOp_Field_Stop_$eq[A](self: Rep[SortOp[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = SortOp_Field_Stop_$eq[A](self, x$1)
  def sortOp_Field_Stop[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = SortOp_Field_Stop[A](self)
  def sortOp_Field_Child_$eq[A](self: Rep[SortOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = SortOp_Field_Child_$eq[A](self, x$1)
  def sortOp_Field_Child[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = SortOp_Field_Child[A](self)
  type SortOp[A] = ch.epfl.data.legobase.queryengine.push.SortOp[A]
}
trait SortOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait SortOpImplementations { this: DeepDSL =>
  override def sortOpNext[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.parent.next();
      __whileDo(self.stop.unary_$bang.$amp$amp(infix_$bang$eq(self.sortedTree.size, unit(0))), {
        val elem: this.Rep[A] = self.sortedTree.head;
        self.sortedTree.$minus$eq(elem);
        self.child.consume(infix_asInstanceOf[ch.epfl.data.pardis.shallow.Record](elem))
      })
    }
  }
  override def sortOpReset[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.parent.reset();
      self.open()
    }
  }
  override def sortOpOpen[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def sortOpConsume[A](self: Rep[SortOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    {
      self.sortedTree.$plus$eq(infix_asInstanceOf[A](tuple));
      unit(())
    }
  }
}
trait SortOpPartialEvaluation extends SortOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def sortOp_Field_OrderingFunc[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[((A, A) => Int)] = self match {
    case Def(node: SortOpNew[_]) => node.orderingFunc
    case _                       => super.sortOp_Field_OrderingFunc[A](self)(typeA)
  }
  override def sortOp_Field_Parent[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = self match {
    case Def(node: SortOpNew[_]) => node.parent
    case _                       => super.sortOp_Field_Parent[A](self)(typeA)
  }

  // Mutable field inlining 
  override def sortOp_Field_Child_$eq[A](self: Rep[SortOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def sortOp_Field_Child[A](self: Rep[SortOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait SortOpComponent extends SortOpOps with SortOpImplicits { this: DeepDSL => }
trait HashJoinOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class HashJoinOpType[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) extends TypeRep[HashJoinOp[A, B, C]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = HashJoinOpType(newArguments(0).asInstanceOf[TypeRep[_ <: ch.epfl.data.pardis.shallow.Record]], newArguments(1).asInstanceOf[TypeRep[_ <: ch.epfl.data.pardis.shallow.Record]], newArguments(2).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    private implicit val tagC = typeC.typeTag
    val name = s"HashJoinOp[${typeA.name}, ${typeB.name}, ${typeC.name}]"
    val typeArguments = List(typeA, typeB, typeC)

    val typeTag = scala.reflect.runtime.universe.typeTag[HashJoinOp[A, B, C]]
  }
  implicit def typeHashJoinOp[A <: ch.epfl.data.pardis.shallow.Record: TypeRep, B <: ch.epfl.data.pardis.shallow.Record: TypeRep, C: TypeRep] = HashJoinOpType(implicitly[TypeRep[A]], implicitly[TypeRep[B]], implicitly[TypeRep[C]])
  implicit class HashJoinOpRep[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) {
    def reset(): Rep[Unit] = hashJoinOpReset[A, B, C](self)(typeA, typeB, typeC)
    def open(): Rep[Unit] = hashJoinOpOpen[A, B, C](self)(typeA, typeB, typeC)
    def next(): Rep[Unit] = hashJoinOpNext[A, B, C](self)(typeA, typeB, typeC)
    def consume(tuple: Rep[Record]): Rep[Unit] = hashJoinOpConsume[A, B, C](self, tuple)(typeA, typeB, typeC)
    def hm: Rep[HashMap[C, ArrayBuffer[A]]] = hashJoinOp_Field_Hm[A, B, C](self)(typeA, typeB, typeC)
    def expectedSize: Rep[Int] = hashJoinOp_Field_ExpectedSize[A, B, C](self)(typeA, typeB, typeC)
    def mode_=(x$1: Rep[Int]): Rep[Unit] = hashJoinOp_Field_Mode_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def mode: Rep[Int] = hashJoinOp_Field_Mode[A, B, C](self)(typeA, typeB, typeC)
    def rightHash: Rep[(B => C)] = hashJoinOp_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
    def leftHash: Rep[(A => C)] = hashJoinOp_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
    def joinCond: Rep[((A, B) => Boolean)] = hashJoinOp_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
    def rightAlias: Rep[String] = hashJoinOp_Field_RightAlias[A, B, C](self)(typeA, typeB, typeC)
    def leftAlias: Rep[String] = hashJoinOp_Field_LeftAlias[A, B, C](self)(typeA, typeB, typeC)
    def rightParent: Rep[Operator[B]] = hashJoinOp_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
    def leftParent: Rep[Operator[A]] = hashJoinOp_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = hashJoinOp_Field_Stop_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def stop: Rep[Boolean] = hashJoinOp_Field_Stop[A, B, C](self)(typeA, typeB, typeC)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = hashJoinOp_Field_Child_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def child: Rep[Operator[Any]] = hashJoinOp_Field_Child[A, B, C](self)(typeA, typeB, typeC)
  }
  object HashJoinOp {

  }
  // constructors
  def __newHashJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], leftAlias: Rep[String], rightAlias: Rep[String])(joinCond: Rep[((A, B) => Boolean)])(leftHash: Rep[(A => C)])(rightHash: Rep[(B => C)])(implicit overload1: Overloaded1, typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashJoinOp[A, B, C]] = hashJoinOpNew1[A, B, C](leftParent, rightParent, leftAlias, rightAlias, joinCond, leftHash, rightHash)(typeA, typeB, typeC)
  def __newHashJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]])(joinCond: Rep[((A, B) => Boolean)])(leftHash: Rep[(A => C)])(rightHash: Rep[(B => C)])(implicit overload2: Overloaded2, typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashJoinOp[A, B, C]] = hashJoinOpNew2[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)(typeA, typeB, typeC)
  // case classes
  case class HashJoinOpNew1[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], leftAlias: Rep[String], rightAlias: Rep[String], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends ConstructorDef[HashJoinOp[A, B, C]](List(typeA, typeB, typeC), "HashJoinOp", List(List(leftParent, rightParent, leftAlias, rightAlias), List(joinCond), List(leftHash), List(rightHash))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinOpNew2[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends ConstructorDef[HashJoinOp[A, B, C]](List(typeA, typeB, typeC), "HashJoinOp", List(List(leftParent, rightParent), List(joinCond), List(leftHash), List(rightHash))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinOp_Field_Hm[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[HashMap[C, ArrayBuffer[A]]](self, "hm") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_ExpectedSize[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Int])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Int](self, "mode", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Int](self, "mode") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinOp_Field_RightHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(B => C)](self, "rightHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_LeftHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(A => C)](self, "leftHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[((A, B) => Boolean)](self, "joinCond") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_RightAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[String](self, "rightAlias") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_LeftAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[String](self, "leftAlias") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[B]](self, "rightParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[A]](self, "leftParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinOp_Field_Stop_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinOp_Field_Stop[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  // method definitions
  def hashJoinOpNew1[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], leftAlias: Rep[String], rightAlias: Rep[String], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashJoinOp[A, B, C]] = HashJoinOpNew1[A, B, C](leftParent, rightParent, leftAlias, rightAlias, joinCond, leftHash, rightHash)
  def hashJoinOpNew2[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashJoinOp[A, B, C]] = HashJoinOpNew2[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)
  def hashJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOpReset[A, B, C](self)
  def hashJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOpOpen[A, B, C](self)
  def hashJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOpNext[A, B, C](self)
  def hashJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOpConsume[A, B, C](self, tuple)
  def hashJoinOp_Field_Hm[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashMap[C, ArrayBuffer[A]]] = HashJoinOp_Field_Hm[A, B, C](self)
  def hashJoinOp_Field_ExpectedSize[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = HashJoinOp_Field_ExpectedSize[A, B, C](self)
  def hashJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOp_Field_Mode_$eq[A, B, C](self, x$1)
  def hashJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = HashJoinOp_Field_Mode[A, B, C](self)
  def hashJoinOp_Field_RightHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = HashJoinOp_Field_RightHash[A, B, C](self)
  def hashJoinOp_Field_LeftHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = HashJoinOp_Field_LeftHash[A, B, C](self)
  def hashJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = HashJoinOp_Field_JoinCond[A, B, C](self)
  def hashJoinOp_Field_RightAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[String] = HashJoinOp_Field_RightAlias[A, B, C](self)
  def hashJoinOp_Field_LeftAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[String] = HashJoinOp_Field_LeftAlias[A, B, C](self)
  def hashJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = HashJoinOp_Field_RightParent[A, B, C](self)
  def hashJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = HashJoinOp_Field_LeftParent[A, B, C](self)
  def hashJoinOp_Field_Stop_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOp_Field_Stop_$eq[A, B, C](self, x$1)
  def hashJoinOp_Field_Stop[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Boolean] = HashJoinOp_Field_Stop[A, B, C](self)
  def hashJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinOp_Field_Child_$eq[A, B, C](self, x$1)
  def hashJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] = HashJoinOp_Field_Child[A, B, C](self)
  type HashJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C] = ch.epfl.data.legobase.queryengine.push.HashJoinOp[A, B, C]
}
trait HashJoinOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait HashJoinOpImplementations { this: DeepDSL =>
  override def hashJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.rightParent.reset();
      self.leftParent.reset();
      self.hm.clear()
    }
  }
  override def hashJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.leftParent.child_$eq(self);
      self.rightParent.child_$eq(self);
      self.leftParent.open();
      self.rightParent.open()
    }
  }
  override def hashJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.leftParent.next();
      self.mode_$eq(self.mode.$plus(unit(1)));
      self.rightParent.next();
      self.mode_$eq(self.mode.$plus(unit(1)))
    }
  }
  override def hashJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    __ifThenElse(infix_$eq$eq(self.mode, unit(0)), {
      val k: this.Rep[C] = __app(self.leftHash).apply(infix_asInstanceOf[A](tuple));
      val v: this.Rep[scala.collection.mutable.ArrayBuffer[A]] = self.hm.getOrElseUpdate(k, ArrayBuffer.apply[A]());
      v.append(infix_asInstanceOf[A](tuple))
    }, __ifThenElse(infix_$eq$eq(self.mode, unit(1)), {
      val k: this.Rep[C] = __app(self.rightHash).apply(infix_asInstanceOf[B](tuple));
      __ifThenElse(self.hm.contains(k), {
        val tmpBuffer: this.Rep[scala.collection.mutable.ArrayBuffer[A]] = self.hm.apply(k);
        var tmpCount: this.Var[Int] = __newVar(unit(0));
        var break: this.Var[Boolean] = __newVar(unit(false));
        val size: this.Rep[Int] = tmpBuffer.size;
        __whileDo(self.stop.unary_$bang.$amp$amp(__readVar(break).unary_$bang), {
          val bufElem: this.Rep[A] = tmpBuffer.apply(__readVar(tmpCount));
          __ifThenElse(__app(self.joinCond).apply(bufElem, infix_asInstanceOf[B](tuple)), {
            val res: this.Rep[ch.epfl.data.pardis.shallow.DynamicCompositeRecord[A, B]] = RecordOps[A](bufElem).concatenateDynamic[B](infix_asInstanceOf[B](tuple), self.leftAlias, self.rightAlias);
            self.child.consume(res)
          }, unit(()));
          __ifThenElse(__readVar(tmpCount).$plus(unit(1)).$greater$eq(size), __assign(break, unit(true)), unit(()));
          __assign(tmpCount, __readVar(tmpCount).$plus(unit(1)))
        })
      }, unit(()))
    }, unit(())))
  }
}
trait HashJoinOpPartialEvaluation extends HashJoinOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def hashJoinOp_Field_RightHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.rightHash
    case Def(node: HashJoinOpNew2[_, _, _]) => node.rightHash
    case _                                  => super.hashJoinOp_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinOp_Field_LeftHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.leftHash
    case Def(node: HashJoinOpNew2[_, _, _]) => node.leftHash
    case _                                  => super.hashJoinOp_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.joinCond
    case Def(node: HashJoinOpNew2[_, _, _]) => node.joinCond
    case _                                  => super.hashJoinOp_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinOp_Field_RightAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[String] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.rightAlias
    case _                                  => super.hashJoinOp_Field_RightAlias[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinOp_Field_LeftAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[String] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.leftAlias
    case _                                  => super.hashJoinOp_Field_LeftAlias[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.rightParent
    case Def(node: HashJoinOpNew2[_, _, _]) => node.rightParent
    case _                                  => super.hashJoinOp_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = self match {
    case Def(node: HashJoinOpNew1[_, _, _]) => node.leftParent
    case Def(node: HashJoinOpNew2[_, _, _]) => node.leftParent
    case _                                  => super.hashJoinOp_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
  }

  // Mutable field inlining 
  override def hashJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "mode") = x$1
    unit(())
  }

  override def hashJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] =
    mutableFieldValues.get(self -> "mode").getOrElse(unit(0)).asInstanceOf[Rep[Int]]
  override def hashJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def hashJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[HashJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait HashJoinOpComponent extends HashJoinOpOps with HashJoinOpImplicits { this: DeepDSL => }
trait WindowOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class WindowOpType[A, B, C](typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) extends TypeRep[WindowOp[A, B, C]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = WindowOpType(newArguments(0).asInstanceOf[TypeRep[_]], newArguments(1).asInstanceOf[TypeRep[_]], newArguments(2).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    private implicit val tagC = typeC.typeTag
    val name = s"WindowOp[${typeA.name}, ${typeB.name}, ${typeC.name}]"
    val typeArguments = List(typeA, typeB, typeC)

    val typeTag = scala.reflect.runtime.universe.typeTag[WindowOp[A, B, C]]
  }
  implicit def typeWindowOp[A: TypeRep, B: TypeRep, C: TypeRep] = WindowOpType(implicitly[TypeRep[A]], implicitly[TypeRep[B]], implicitly[TypeRep[C]])
  implicit class WindowOpRep[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) {
    def open(): Rep[Unit] = windowOpOpen[A, B, C](self)(typeA, typeB, typeC)
    def reset(): Rep[Unit] = windowOpReset[A, B, C](self)(typeA, typeB, typeC)
    def next(): Rep[Unit] = windowOpNext[A, B, C](self)(typeA, typeB, typeC)
    def consume(tuple: Rep[Record]): Rep[Unit] = windowOpConsume[A, B, C](self, tuple)(typeA, typeB, typeC)
    def expectedSize: Rep[Int] = windowOp_Field_ExpectedSize[A, B, C](self)(typeA, typeB, typeC)
    def hm: Rep[HashMap[B, ArrayBuffer[A]]] = windowOp_Field_Hm[A, B, C](self)(typeA, typeB, typeC)
    def wndf: Rep[(ArrayBuffer[A] => C)] = windowOp_Field_Wndf[A, B, C](self)(typeA, typeB, typeC)
    def grp: Rep[(A => B)] = windowOp_Field_Grp[A, B, C](self)(typeA, typeB, typeC)
    def parent: Rep[Operator[A]] = windowOp_Field_Parent[A, B, C](self)(typeA, typeB, typeC)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = windowOp_Field_Stop_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def stop: Rep[Boolean] = windowOp_Field_Stop[A, B, C](self)(typeA, typeB, typeC)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = windowOp_Field_Child_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def child: Rep[Operator[Any]] = windowOp_Field_Child[A, B, C](self)(typeA, typeB, typeC)
  }
  object WindowOp {

  }
  // constructors
  def __newWindowOp[A, B, C](parent: Rep[Operator[A]])(grp: Rep[(A => B)])(wndf: Rep[(ArrayBuffer[A] => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[WindowOp[A, B, C]] = windowOpNew[A, B, C](parent, grp, wndf)(typeA, typeB, typeC)
  // case classes
  case class WindowOpNew[A, B, C](parent: Rep[Operator[A]], grp: Rep[((A) => B)], wndf: Rep[((ArrayBuffer[A]) => C)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends ConstructorDef[WindowOp[A, B, C]](List(typeA, typeB, typeC), "WindowOp", List(List(parent), List(grp), List(wndf))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class WindowOpOpen[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class WindowOpReset[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class WindowOpNext[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class WindowOpConsume[A, B, C](self: Rep[WindowOp[A, B, C]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class WindowOp_Field_ExpectedSize[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class WindowOp_Field_Hm[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[HashMap[B, ArrayBuffer[A]]](self, "hm") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class WindowOp_Field_Wndf[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(ArrayBuffer[A] => C)](self, "wndf") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class WindowOp_Field_Grp[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(A => B)](self, "grp") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class WindowOp_Field_Parent[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class WindowOp_Field_Stop_$eq[A, B, C](self: Rep[WindowOp[A, B, C]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class WindowOp_Field_Stop[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class WindowOp_Field_Child_$eq[A, B, C](self: Rep[WindowOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class WindowOp_Field_Child[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  // method definitions
  def windowOpNew[A, B, C](parent: Rep[Operator[A]], grp: Rep[((A) => B)], wndf: Rep[((ArrayBuffer[A]) => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[WindowOp[A, B, C]] = WindowOpNew[A, B, C](parent, grp, wndf)
  def windowOpOpen[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = WindowOpOpen[A, B, C](self)
  def windowOpReset[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = WindowOpReset[A, B, C](self)
  def windowOpNext[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = WindowOpNext[A, B, C](self)
  def windowOpConsume[A, B, C](self: Rep[WindowOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = WindowOpConsume[A, B, C](self, tuple)
  def windowOp_Field_ExpectedSize[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = WindowOp_Field_ExpectedSize[A, B, C](self)
  def windowOp_Field_Hm[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashMap[B, ArrayBuffer[A]]] = WindowOp_Field_Hm[A, B, C](self)
  def windowOp_Field_Wndf[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(ArrayBuffer[A] => C)] = WindowOp_Field_Wndf[A, B, C](self)
  def windowOp_Field_Grp[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => B)] = WindowOp_Field_Grp[A, B, C](self)
  def windowOp_Field_Parent[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = WindowOp_Field_Parent[A, B, C](self)
  def windowOp_Field_Stop_$eq[A, B, C](self: Rep[WindowOp[A, B, C]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = WindowOp_Field_Stop_$eq[A, B, C](self, x$1)
  def windowOp_Field_Stop[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Boolean] = WindowOp_Field_Stop[A, B, C](self)
  def windowOp_Field_Child_$eq[A, B, C](self: Rep[WindowOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = WindowOp_Field_Child_$eq[A, B, C](self, x$1)
  def windowOp_Field_Child[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] = WindowOp_Field_Child[A, B, C](self)
  type WindowOp[A, B, C] = ch.epfl.data.legobase.queryengine.push.WindowOp[A, B, C]
}
trait WindowOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait WindowOpImplementations { this: DeepDSL =>
  override def windowOpOpen[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def windowOpReset[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.parent.reset();
      self.hm.clear();
      self.open()
    }
  }
  override def windowOpNext[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.parent.next();
      var keySet: this.Var[scala.collection.mutable.Set[B]] = __newVar(Set.apply[B](self.hm.keySet.toSeq));
      __whileDo(self.stop.unary_$bang.$amp$amp(infix_$bang$eq(self.hm.size, unit(0))), {
        val k: this.Rep[B] = __readVar(keySet).head;
        __readVar(keySet).remove(k);
        val elem: this.Rep[Option[scala.collection.mutable.ArrayBuffer[A]]] = self.hm.remove(k);
        val wnd: this.Rep[C] = __app(self.wndf).apply(elem.get);
        val key: this.Rep[B] = __app(self.grp).apply(elem.get.apply(unit(0)));
        self.child.consume(__newWindowRecord[B, C](key, wnd))
      })
    }
  }
  override def windowOpConsume[A, B, C](self: Rep[WindowOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      val key: this.Rep[B] = __app(self.grp).apply(infix_asInstanceOf[A](tuple));
      val v: this.Rep[scala.collection.mutable.ArrayBuffer[A]] = self.hm.getOrElseUpdate(key, ArrayBuffer.apply[A]());
      v.append(infix_asInstanceOf[A](tuple))
    }
  }
}
trait WindowOpPartialEvaluation extends WindowOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def windowOp_Field_Wndf[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(ArrayBuffer[A] => C)] = self match {
    case Def(node: WindowOpNew[_, _, _]) => node.wndf
    case _                               => super.windowOp_Field_Wndf[A, B, C](self)(typeA, typeB, typeC)
  }
  override def windowOp_Field_Grp[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => B)] = self match {
    case Def(node: WindowOpNew[_, _, _]) => node.grp
    case _                               => super.windowOp_Field_Grp[A, B, C](self)(typeA, typeB, typeC)
  }
  override def windowOp_Field_Parent[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = self match {
    case Def(node: WindowOpNew[_, _, _]) => node.parent
    case _                               => super.windowOp_Field_Parent[A, B, C](self)(typeA, typeB, typeC)
  }

  // Mutable field inlining 
  override def windowOp_Field_Child_$eq[A, B, C](self: Rep[WindowOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def windowOp_Field_Child[A, B, C](self: Rep[WindowOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait WindowOpComponent extends WindowOpOps with WindowOpImplicits { this: DeepDSL => }
trait LeftHashSemiJoinOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class LeftHashSemiJoinOpType[A, B, C](typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) extends TypeRep[LeftHashSemiJoinOp[A, B, C]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = LeftHashSemiJoinOpType(newArguments(0).asInstanceOf[TypeRep[_]], newArguments(1).asInstanceOf[TypeRep[_]], newArguments(2).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    private implicit val tagC = typeC.typeTag
    val name = s"LeftHashSemiJoinOp[${typeA.name}, ${typeB.name}, ${typeC.name}]"
    val typeArguments = List(typeA, typeB, typeC)

    val typeTag = scala.reflect.runtime.universe.typeTag[LeftHashSemiJoinOp[A, B, C]]
  }
  implicit def typeLeftHashSemiJoinOp[A: TypeRep, B: TypeRep, C: TypeRep] = LeftHashSemiJoinOpType(implicitly[TypeRep[A]], implicitly[TypeRep[B]], implicitly[TypeRep[C]])
  implicit class LeftHashSemiJoinOpRep[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) {
    def open(): Rep[Unit] = leftHashSemiJoinOpOpen[A, B, C](self)(typeA, typeB, typeC)
    def reset(): Rep[Unit] = leftHashSemiJoinOpReset[A, B, C](self)(typeA, typeB, typeC)
    def next(): Rep[Unit] = leftHashSemiJoinOpNext[A, B, C](self)(typeA, typeB, typeC)
    def consume(tuple: Rep[Record]): Rep[Unit] = leftHashSemiJoinOpConsume[A, B, C](self, tuple)(typeA, typeB, typeC)
    def expectedSize: Rep[Int] = leftHashSemiJoinOp_Field_ExpectedSize[A, B, C](self)(typeA, typeB, typeC)
    def hm: Rep[HashMap[C, ArrayBuffer[B]]] = leftHashSemiJoinOp_Field_Hm[A, B, C](self)(typeA, typeB, typeC)
    def mode_=(x$1: Rep[Int]): Rep[Unit] = leftHashSemiJoinOp_Field_Mode_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def mode: Rep[Int] = leftHashSemiJoinOp_Field_Mode[A, B, C](self)(typeA, typeB, typeC)
    def rightHash: Rep[(B => C)] = leftHashSemiJoinOp_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
    def leftHash: Rep[(A => C)] = leftHashSemiJoinOp_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
    def joinCond: Rep[((A, B) => Boolean)] = leftHashSemiJoinOp_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
    def rightParent: Rep[Operator[B]] = leftHashSemiJoinOp_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
    def leftParent: Rep[Operator[A]] = leftHashSemiJoinOp_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = leftHashSemiJoinOp_Field_Stop_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def stop: Rep[Boolean] = leftHashSemiJoinOp_Field_Stop[A, B, C](self)(typeA, typeB, typeC)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = leftHashSemiJoinOp_Field_Child_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def child: Rep[Operator[Any]] = leftHashSemiJoinOp_Field_Child[A, B, C](self)(typeA, typeB, typeC)
  }
  object LeftHashSemiJoinOp {

  }
  // constructors
  def __newLeftHashSemiJoinOp[A, B, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]])(joinCond: Rep[((A, B) => Boolean)])(leftHash: Rep[(A => C)])(rightHash: Rep[(B => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[LeftHashSemiJoinOp[A, B, C]] = leftHashSemiJoinOpNew[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)(typeA, typeB, typeC)
  // case classes
  case class LeftHashSemiJoinOpNew[A, B, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends ConstructorDef[LeftHashSemiJoinOp[A, B, C]](List(typeA, typeB, typeC), "LeftHashSemiJoinOp", List(List(leftParent, rightParent), List(joinCond), List(leftHash), List(rightHash))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftHashSemiJoinOpOpen[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftHashSemiJoinOpReset[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftHashSemiJoinOpNext[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftHashSemiJoinOpConsume[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftHashSemiJoinOp_Field_ExpectedSize[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_Hm[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[HashMap[C, ArrayBuffer[B]]](self, "hm") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_Mode_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Int])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Int](self, "mode", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftHashSemiJoinOp_Field_Mode[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Int](self, "mode") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftHashSemiJoinOp_Field_RightHash[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(B => C)](self, "rightHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_LeftHash[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(A => C)](self, "leftHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_JoinCond[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[((A, B) => Boolean)](self, "joinCond") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_RightParent[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[B]](self, "rightParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_LeftParent[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[A]](self, "leftParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftHashSemiJoinOp_Field_Stop_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftHashSemiJoinOp_Field_Stop[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftHashSemiJoinOp_Field_Child_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftHashSemiJoinOp_Field_Child[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  // method definitions
  def leftHashSemiJoinOpNew[A, B, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[LeftHashSemiJoinOp[A, B, C]] = LeftHashSemiJoinOpNew[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)
  def leftHashSemiJoinOpOpen[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOpOpen[A, B, C](self)
  def leftHashSemiJoinOpReset[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOpReset[A, B, C](self)
  def leftHashSemiJoinOpNext[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOpNext[A, B, C](self)
  def leftHashSemiJoinOpConsume[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOpConsume[A, B, C](self, tuple)
  def leftHashSemiJoinOp_Field_ExpectedSize[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = LeftHashSemiJoinOp_Field_ExpectedSize[A, B, C](self)
  def leftHashSemiJoinOp_Field_Hm[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashMap[C, ArrayBuffer[B]]] = LeftHashSemiJoinOp_Field_Hm[A, B, C](self)
  def leftHashSemiJoinOp_Field_Mode_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOp_Field_Mode_$eq[A, B, C](self, x$1)
  def leftHashSemiJoinOp_Field_Mode[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = LeftHashSemiJoinOp_Field_Mode[A, B, C](self)
  def leftHashSemiJoinOp_Field_RightHash[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = LeftHashSemiJoinOp_Field_RightHash[A, B, C](self)
  def leftHashSemiJoinOp_Field_LeftHash[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = LeftHashSemiJoinOp_Field_LeftHash[A, B, C](self)
  def leftHashSemiJoinOp_Field_JoinCond[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = LeftHashSemiJoinOp_Field_JoinCond[A, B, C](self)
  def leftHashSemiJoinOp_Field_RightParent[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = LeftHashSemiJoinOp_Field_RightParent[A, B, C](self)
  def leftHashSemiJoinOp_Field_LeftParent[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = LeftHashSemiJoinOp_Field_LeftParent[A, B, C](self)
  def leftHashSemiJoinOp_Field_Stop_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOp_Field_Stop_$eq[A, B, C](self, x$1)
  def leftHashSemiJoinOp_Field_Stop[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Boolean] = LeftHashSemiJoinOp_Field_Stop[A, B, C](self)
  def leftHashSemiJoinOp_Field_Child_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftHashSemiJoinOp_Field_Child_$eq[A, B, C](self, x$1)
  def leftHashSemiJoinOp_Field_Child[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] = LeftHashSemiJoinOp_Field_Child[A, B, C](self)
  type LeftHashSemiJoinOp[A, B, C] = ch.epfl.data.legobase.queryengine.push.LeftHashSemiJoinOp[A, B, C]
}
trait LeftHashSemiJoinOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait LeftHashSemiJoinOpImplementations { this: DeepDSL =>
  override def leftHashSemiJoinOpOpen[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.leftParent.child_$eq(self);
      self.rightParent.child_$eq(self);
      self.leftParent.open();
      self.rightParent.open()
    }
  }
  override def leftHashSemiJoinOpReset[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.rightParent.reset();
      self.leftParent.reset();
      self.hm.clear()
    }
  }
  override def leftHashSemiJoinOpNext[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.rightParent.next();
      self.mode_$eq(unit(1));
      self.leftParent.next()
    }
  }
  override def leftHashSemiJoinOpConsume[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    __ifThenElse(infix_$eq$eq(self.mode, unit(0)), {
      val k: this.Rep[C] = __app(self.rightHash).apply(infix_asInstanceOf[B](tuple));
      val v: this.Rep[scala.collection.mutable.ArrayBuffer[B]] = self.hm.getOrElseUpdate(k, ArrayBuffer.apply[B]());
      v.append(infix_asInstanceOf[B](tuple))
    }, {
      val k: this.Rep[C] = __app(self.leftHash).apply(infix_asInstanceOf[A](tuple));
      __ifThenElse(self.hm.contains(k), {
        val tmpBuffer: this.Rep[scala.collection.mutable.ArrayBuffer[B]] = self.hm.apply(k);
        var i: this.Var[Int] = __newVar(unit(0));
        var found: this.Var[Boolean] = __newVar(unit(false));
        val size: this.Rep[Int] = tmpBuffer.size;
        var break: this.Var[Boolean] = __newVar(unit(false));
        __whileDo(__readVar(found).unary_$bang.$amp$amp(__readVar(break).unary_$bang), __ifThenElse(__app(self.joinCond).apply(infix_asInstanceOf[A](tuple), tmpBuffer.apply(__readVar(i))), __assign(found, unit(true)), {
          __ifThenElse(__readVar(i).$plus(unit(1)).$greater$eq(size), __assign(break, unit(true)), unit(()));
          __assign(i, __readVar(i).$plus(unit(1)))
        }));
        __ifThenElse(infix_$eq$eq(__readVar(found), unit(true)), self.child.consume(infix_asInstanceOf[ch.epfl.data.pardis.shallow.Record](tuple)), unit(()))
      }, unit(()))
    })
  }
}
trait LeftHashSemiJoinOpPartialEvaluation extends LeftHashSemiJoinOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def leftHashSemiJoinOp_Field_RightHash[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = self match {
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) => node.rightHash
    case _                                         => super.leftHashSemiJoinOp_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftHashSemiJoinOp_Field_LeftHash[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = self match {
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) => node.leftHash
    case _                                         => super.leftHashSemiJoinOp_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftHashSemiJoinOp_Field_JoinCond[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = self match {
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) => node.joinCond
    case _                                         => super.leftHashSemiJoinOp_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftHashSemiJoinOp_Field_RightParent[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = self match {
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) => node.rightParent
    case _                                         => super.leftHashSemiJoinOp_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftHashSemiJoinOp_Field_LeftParent[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = self match {
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) => node.leftParent
    case _                                         => super.leftHashSemiJoinOp_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
  }

  // Mutable field inlining 
  override def leftHashSemiJoinOp_Field_Mode_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "mode") = x$1
    unit(())
  }

  override def leftHashSemiJoinOp_Field_Mode[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] =
    mutableFieldValues.get(self -> "mode").getOrElse(unit(0)).asInstanceOf[Rep[Int]]
  override def leftHashSemiJoinOp_Field_Child_$eq[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def leftHashSemiJoinOp_Field_Child[A, B, C](self: Rep[LeftHashSemiJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait LeftHashSemiJoinOpComponent extends LeftHashSemiJoinOpOps with LeftHashSemiJoinOpImplicits { this: DeepDSL => }
trait NestedLoopsJoinOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class NestedLoopsJoinOpType[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](typeA: TypeRep[A], typeB: TypeRep[B]) extends TypeRep[NestedLoopsJoinOp[A, B]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = NestedLoopsJoinOpType(newArguments(0).asInstanceOf[TypeRep[_ <: ch.epfl.data.pardis.shallow.Record]], newArguments(1).asInstanceOf[TypeRep[_ <: ch.epfl.data.pardis.shallow.Record]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    val name = s"NestedLoopsJoinOp[${typeA.name}, ${typeB.name}]"
    val typeArguments = List(typeA, typeB)

    val typeTag = scala.reflect.runtime.universe.typeTag[NestedLoopsJoinOp[A, B]]
  }
  implicit def typeNestedLoopsJoinOp[A <: ch.epfl.data.pardis.shallow.Record: TypeRep, B <: ch.epfl.data.pardis.shallow.Record: TypeRep] = NestedLoopsJoinOpType(implicitly[TypeRep[A]], implicitly[TypeRep[B]])
  implicit class NestedLoopsJoinOpRep[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]) {
    def open(): Rep[Unit] = nestedLoopsJoinOpOpen[A, B](self)(typeA, typeB)
    def reset(): Rep[Unit] = nestedLoopsJoinOpReset[A, B](self)(typeA, typeB)
    def next(): Rep[Unit] = nestedLoopsJoinOpNext[A, B](self)(typeA, typeB)
    def consume(tuple: Rep[Record]): Rep[Unit] = nestedLoopsJoinOpConsume[A, B](self, tuple)(typeA, typeB)
    def expectedSize: Rep[Int] = nestedLoopsJoinOp_Field_ExpectedSize[A, B](self)(typeA, typeB)
    def leftTuple_=(x$1: Rep[A]): Rep[Unit] = nestedLoopsJoinOp_Field_LeftTuple_$eq[A, B](self, x$1)(typeA, typeB)
    def leftTuple: Rep[A] = nestedLoopsJoinOp_Field_LeftTuple[A, B](self)(typeA, typeB)
    def mode_=(x$1: Rep[Int]): Rep[Unit] = nestedLoopsJoinOp_Field_Mode_$eq[A, B](self, x$1)(typeA, typeB)
    def mode: Rep[Int] = nestedLoopsJoinOp_Field_Mode[A, B](self)(typeA, typeB)
    def joinCond: Rep[((A, B) => Boolean)] = nestedLoopsJoinOp_Field_JoinCond[A, B](self)(typeA, typeB)
    def rightAlias: Rep[String] = nestedLoopsJoinOp_Field_RightAlias[A, B](self)(typeA, typeB)
    def leftAlias: Rep[String] = nestedLoopsJoinOp_Field_LeftAlias[A, B](self)(typeA, typeB)
    def rightParent: Rep[Operator[B]] = nestedLoopsJoinOp_Field_RightParent[A, B](self)(typeA, typeB)
    def leftParent: Rep[Operator[A]] = nestedLoopsJoinOp_Field_LeftParent[A, B](self)(typeA, typeB)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = nestedLoopsJoinOp_Field_Stop_$eq[A, B](self, x$1)(typeA, typeB)
    def stop: Rep[Boolean] = nestedLoopsJoinOp_Field_Stop[A, B](self)(typeA, typeB)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = nestedLoopsJoinOp_Field_Child_$eq[A, B](self, x$1)(typeA, typeB)
    def child: Rep[Operator[Any]] = nestedLoopsJoinOp_Field_Child[A, B](self)(typeA, typeB)
  }
  object NestedLoopsJoinOp {

  }
  // constructors
  def __newNestedLoopsJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], leftAlias: Rep[String], rightAlias: Rep[String])(joinCond: Rep[((A, B) => Boolean)])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[NestedLoopsJoinOp[A, B]] = nestedLoopsJoinOpNew[A, B](leftParent, rightParent, leftAlias, rightAlias, joinCond)(typeA, typeB)
  // case classes
  case class NestedLoopsJoinOpNew[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], leftAlias: Rep[String], rightAlias: Rep[String], joinCond: Rep[((A, B) => Boolean)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends ConstructorDef[NestedLoopsJoinOp[A, B]](List(typeA, typeB), "NestedLoopsJoinOp", List(List(leftParent, rightParent, leftAlias, rightAlias), List(joinCond))) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class NestedLoopsJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class NestedLoopsJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class NestedLoopsJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class NestedLoopsJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class NestedLoopsJoinOp_Field_ExpectedSize[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class NestedLoopsJoinOp_Field_LeftTuple_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[A])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldSetter[A](self, "leftTuple", x$1) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class NestedLoopsJoinOp_Field_LeftTuple[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldGetter[A](self, "leftTuple") {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class NestedLoopsJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Int])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldSetter[Int](self, "mode", x$1) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class NestedLoopsJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldGetter[Int](self, "mode") {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class NestedLoopsJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[((A, B) => Boolean)](self, "joinCond") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class NestedLoopsJoinOp_Field_RightAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[String](self, "rightAlias") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class NestedLoopsJoinOp_Field_LeftAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[String](self, "leftAlias") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class NestedLoopsJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Operator[B]](self, "rightParent") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class NestedLoopsJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldDef[Operator[A]](self, "leftParent") {
    override def curriedConstructor = (copy[A, B] _)
    override def isPure = true

  }

  case class NestedLoopsJoinOp_Field_Stop_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class NestedLoopsJoinOp_Field_Stop[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B] _)
  }

  case class NestedLoopsJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B] _).curried
  }

  case class NestedLoopsJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B] _)
  }

  // method definitions
  def nestedLoopsJoinOpNew[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], leftAlias: Rep[String], rightAlias: Rep[String], joinCond: Rep[((A, B) => Boolean)])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[NestedLoopsJoinOp[A, B]] = NestedLoopsJoinOpNew[A, B](leftParent, rightParent, leftAlias, rightAlias, joinCond)
  def nestedLoopsJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOpOpen[A, B](self)
  def nestedLoopsJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOpReset[A, B](self)
  def nestedLoopsJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOpNext[A, B](self)
  def nestedLoopsJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOpConsume[A, B](self, tuple)
  def nestedLoopsJoinOp_Field_ExpectedSize[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Int] = NestedLoopsJoinOp_Field_ExpectedSize[A, B](self)
  def nestedLoopsJoinOp_Field_LeftTuple_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[A])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOp_Field_LeftTuple_$eq[A, B](self, x$1)
  def nestedLoopsJoinOp_Field_LeftTuple[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[A] = NestedLoopsJoinOp_Field_LeftTuple[A, B](self)
  def nestedLoopsJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOp_Field_Mode_$eq[A, B](self, x$1)
  def nestedLoopsJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Int] = NestedLoopsJoinOp_Field_Mode[A, B](self)
  def nestedLoopsJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[((A, B) => Boolean)] = NestedLoopsJoinOp_Field_JoinCond[A, B](self)
  def nestedLoopsJoinOp_Field_RightAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[String] = NestedLoopsJoinOp_Field_RightAlias[A, B](self)
  def nestedLoopsJoinOp_Field_LeftAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[String] = NestedLoopsJoinOp_Field_LeftAlias[A, B](self)
  def nestedLoopsJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[B]] = NestedLoopsJoinOp_Field_RightParent[A, B](self)
  def nestedLoopsJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[A]] = NestedLoopsJoinOp_Field_LeftParent[A, B](self)
  def nestedLoopsJoinOp_Field_Stop_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOp_Field_Stop_$eq[A, B](self, x$1)
  def nestedLoopsJoinOp_Field_Stop[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Boolean] = NestedLoopsJoinOp_Field_Stop[A, B](self)
  def nestedLoopsJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = NestedLoopsJoinOp_Field_Child_$eq[A, B](self, x$1)
  def nestedLoopsJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[Any]] = NestedLoopsJoinOp_Field_Child[A, B](self)
  type NestedLoopsJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record] = ch.epfl.data.legobase.queryengine.push.NestedLoopsJoinOp[A, B]
}
trait NestedLoopsJoinOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait NestedLoopsJoinOpImplementations { this: DeepDSL =>
  override def nestedLoopsJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    {
      self.rightParent.child_$eq(self);
      self.leftParent.child_$eq(self);
      self.rightParent.open();
      self.leftParent.open()
    }
  }
  override def nestedLoopsJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    {
      self.rightParent.reset();
      self.leftParent.reset();
      self.leftTuple_$eq(infix_asInstanceOf[A](unit(null)))
    }
  }
  override def nestedLoopsJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    self.leftParent.next()
  }
  override def nestedLoopsJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    __ifThenElse(infix_$eq$eq(self.mode, unit(0)), {
      self.leftTuple_$eq(infix_asInstanceOf[A](tuple));
      self.mode_$eq(unit(1));
      self.rightParent.next();
      self.mode_$eq(unit(0));
      self.rightParent.reset()
    }, __ifThenElse(__app(self.joinCond).apply(self.leftTuple, infix_asInstanceOf[B](tuple)), self.child.consume(RecordOps[A](self.leftTuple).concatenateDynamic[B](infix_asInstanceOf[B](tuple), self.leftAlias, self.rightAlias)), unit(())))
  }
}
trait NestedLoopsJoinOpPartialEvaluation extends NestedLoopsJoinOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def nestedLoopsJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[((A, B) => Boolean)] = self match {
    case Def(node: NestedLoopsJoinOpNew[_, _]) => node.joinCond
    case _                                     => super.nestedLoopsJoinOp_Field_JoinCond[A, B](self)(typeA, typeB)
  }
  override def nestedLoopsJoinOp_Field_RightAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[String] = self match {
    case Def(node: NestedLoopsJoinOpNew[_, _]) => node.rightAlias
    case _                                     => super.nestedLoopsJoinOp_Field_RightAlias[A, B](self)(typeA, typeB)
  }
  override def nestedLoopsJoinOp_Field_LeftAlias[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[String] = self match {
    case Def(node: NestedLoopsJoinOpNew[_, _]) => node.leftAlias
    case _                                     => super.nestedLoopsJoinOp_Field_LeftAlias[A, B](self)(typeA, typeB)
  }
  override def nestedLoopsJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[B]] = self match {
    case Def(node: NestedLoopsJoinOpNew[_, _]) => node.rightParent
    case _                                     => super.nestedLoopsJoinOp_Field_RightParent[A, B](self)(typeA, typeB)
  }
  override def nestedLoopsJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[A]] = self match {
    case Def(node: NestedLoopsJoinOpNew[_, _]) => node.leftParent
    case _                                     => super.nestedLoopsJoinOp_Field_LeftParent[A, B](self)(typeA, typeB)
  }

  // Mutable field inlining 
  override def nestedLoopsJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    mutableFieldValues(self -> "mode") = x$1
    unit(())
  }

  override def nestedLoopsJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Int] =
    mutableFieldValues.get(self -> "mode").getOrElse(unit(0)).asInstanceOf[Rep[Int]]
  override def nestedLoopsJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def nestedLoopsJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record](self: Rep[NestedLoopsJoinOp[A, B]])(implicit typeA: TypeRep[A], typeB: TypeRep[B]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait NestedLoopsJoinOpComponent extends NestedLoopsJoinOpOps with NestedLoopsJoinOpImplicits { this: DeepDSL => }
trait SubquerySingleResultOps extends Base { this: DeepDSL =>
  // Type representation
  case class SubquerySingleResultType[A](typeA: TypeRep[A]) extends TypeRep[SubquerySingleResult[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = SubquerySingleResultType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"SubquerySingleResult[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[SubquerySingleResult[A]]
  }
  implicit def typeSubquerySingleResult[A: TypeRep] = SubquerySingleResultType(implicitly[TypeRep[A]])
  implicit class SubquerySingleResultRep[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]) {
    def open(): Rep[Unit] = subquerySingleResultOpen[A](self)(typeA)
    def next(): Rep[Unit] = subquerySingleResultNext[A](self)(typeA)
    def reset(): Rep[Unit] = subquerySingleResultReset[A](self)(typeA)
    def consume(tuple: Rep[Record]): Rep[Unit] = subquerySingleResultConsume[A](self, tuple)(typeA)
    def getResult: Rep[A] = subquerySingleResultGetResult[A](self)(typeA)
    def expectedSize: Rep[Int] = subquerySingleResult_Field_ExpectedSize[A](self)(typeA)
    def result_=(x$1: Rep[A]): Rep[Unit] = subquerySingleResult_Field_Result_$eq[A](self, x$1)(typeA)
    def result: Rep[A] = subquerySingleResult_Field_Result[A](self)(typeA)
    def parent: Rep[Operator[A]] = subquerySingleResult_Field_Parent[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = subquerySingleResult_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = subquerySingleResult_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = subquerySingleResult_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = subquerySingleResult_Field_Child[A](self)(typeA)
  }
  object SubquerySingleResult {

  }
  // constructors
  def __newSubquerySingleResult[A](parent: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[SubquerySingleResult[A]] = subquerySingleResultNew[A](parent)(typeA)
  // case classes
  case class SubquerySingleResultNew[A](parent: Rep[Operator[A]])(implicit val typeA: TypeRep[A]) extends ConstructorDef[SubquerySingleResult[A]](List(typeA), "SubquerySingleResult", List(List(parent))) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResultOpen[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResultNext[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResultReset[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResultConsume[A](self: Rep[SubquerySingleResult[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SubquerySingleResultGetResult[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FunctionDef[A](Some(self), "getResult", List()) {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResult_Field_ExpectedSize[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SubquerySingleResult_Field_Result_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[A])(implicit val typeA: TypeRep[A]) extends FieldSetter[A](self, "result", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SubquerySingleResult_Field_Result[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[A](self, "result") {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResult_Field_Parent[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class SubquerySingleResult_Field_Stop_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SubquerySingleResult_Field_Stop[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class SubquerySingleResult_Field_Child_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class SubquerySingleResult_Field_Child[A](self: Rep[SubquerySingleResult[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def subquerySingleResultNew[A](parent: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[SubquerySingleResult[A]] = SubquerySingleResultNew[A](parent)
  def subquerySingleResultOpen[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResultOpen[A](self)
  def subquerySingleResultNext[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResultNext[A](self)
  def subquerySingleResultReset[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResultReset[A](self)
  def subquerySingleResultConsume[A](self: Rep[SubquerySingleResult[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResultConsume[A](self, tuple)
  def subquerySingleResultGetResult[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[A] = SubquerySingleResultGetResult[A](self)
  def subquerySingleResult_Field_ExpectedSize[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Int] = SubquerySingleResult_Field_ExpectedSize[A](self)
  def subquerySingleResult_Field_Result_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[A])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResult_Field_Result_$eq[A](self, x$1)
  def subquerySingleResult_Field_Result[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[A] = SubquerySingleResult_Field_Result[A](self)
  def subquerySingleResult_Field_Parent[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = SubquerySingleResult_Field_Parent[A](self)
  def subquerySingleResult_Field_Stop_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResult_Field_Stop_$eq[A](self, x$1)
  def subquerySingleResult_Field_Stop[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = SubquerySingleResult_Field_Stop[A](self)
  def subquerySingleResult_Field_Child_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = SubquerySingleResult_Field_Child_$eq[A](self, x$1)
  def subquerySingleResult_Field_Child[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = SubquerySingleResult_Field_Child[A](self)
  type SubquerySingleResult[A] = ch.epfl.data.legobase.queryengine.push.SubquerySingleResult[A]
}
trait SubquerySingleResultImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait SubquerySingleResultImplementations { this: DeepDSL =>
  override def subquerySingleResultOpen[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    throw __newException(unit("PUSH ENGINE BUG:: Open function in SubqueryResult should never be called!!!!\n"))
  }
  override def subquerySingleResultNext[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    throw __newException(unit("PUSH ENGINE BUG:: Next function in SubqueryResult should never be called!!!!\n"))
  }
  override def subquerySingleResultReset[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    throw __newException(unit("PUSH ENGINE BUG:: Reset function in SubqueryResult should never be called!!!!\n"))
  }
  override def subquerySingleResultConsume[A](self: Rep[SubquerySingleResult[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    self.result_$eq(infix_asInstanceOf[A](tuple))
  }
  override def subquerySingleResultGetResult[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[A] = {
    {
      self.parent.child_$eq(self);
      self.parent.open();
      self.parent.next();
      self.result
    }
  }
}
trait SubquerySingleResultPartialEvaluation extends SubquerySingleResultComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def subquerySingleResult_Field_Parent[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = self match {
    case Def(node: SubquerySingleResultNew[_]) => node.parent
    case _                                     => super.subquerySingleResult_Field_Parent[A](self)(typeA)
  }

  // Mutable field inlining 
  override def subquerySingleResult_Field_Child_$eq[A](self: Rep[SubquerySingleResult[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def subquerySingleResult_Field_Child[A](self: Rep[SubquerySingleResult[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait SubquerySingleResultComponent extends SubquerySingleResultOps with SubquerySingleResultImplicits { this: DeepDSL => }
trait HashJoinAntiOps extends Base { this: DeepDSL =>
  // Type representation
  case class HashJoinAntiType[A, B, C](typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) extends TypeRep[HashJoinAnti[A, B, C]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = HashJoinAntiType(newArguments(0).asInstanceOf[TypeRep[_]], newArguments(1).asInstanceOf[TypeRep[_]], newArguments(2).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    private implicit val tagC = typeC.typeTag
    val name = s"HashJoinAnti[${typeA.name}, ${typeB.name}, ${typeC.name}]"
    val typeArguments = List(typeA, typeB, typeC)

    val typeTag = scala.reflect.runtime.universe.typeTag[HashJoinAnti[A, B, C]]
  }
  implicit def typeHashJoinAnti[A: TypeRep, B: TypeRep, C: TypeRep] = HashJoinAntiType(implicitly[TypeRep[A]], implicitly[TypeRep[B]], implicitly[TypeRep[C]])
  implicit class HashJoinAntiRep[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) {
    def open(): Rep[Unit] = hashJoinAntiOpen[A, B, C](self)(typeA, typeB, typeC)
    def reset(): Rep[Unit] = hashJoinAntiReset[A, B, C](self)(typeA, typeB, typeC)
    def next(): Rep[Unit] = hashJoinAntiNext[A, B, C](self)(typeA, typeB, typeC)
    def consume(tuple: Rep[Record]): Rep[Unit] = hashJoinAntiConsume[A, B, C](self, tuple)(typeA, typeB, typeC)
    def expectedSize: Rep[Int] = hashJoinAnti_Field_ExpectedSize[A, B, C](self)(typeA, typeB, typeC)
    def keySet_=(x$1: Rep[Set[C]]): Rep[Unit] = hashJoinAnti_Field_KeySet_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def keySet: Rep[Set[C]] = hashJoinAnti_Field_KeySet[A, B, C](self)(typeA, typeB, typeC)
    def hm: Rep[HashMap[C, ArrayBuffer[A]]] = hashJoinAnti_Field_Hm[A, B, C](self)(typeA, typeB, typeC)
    def mode_=(x$1: Rep[Int]): Rep[Unit] = hashJoinAnti_Field_Mode_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def mode: Rep[Int] = hashJoinAnti_Field_Mode[A, B, C](self)(typeA, typeB, typeC)
    def rightHash: Rep[(B => C)] = hashJoinAnti_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
    def leftHash: Rep[(A => C)] = hashJoinAnti_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
    def joinCond: Rep[((A, B) => Boolean)] = hashJoinAnti_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
    def rightParent: Rep[Operator[B]] = hashJoinAnti_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
    def leftParent: Rep[Operator[A]] = hashJoinAnti_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = hashJoinAnti_Field_Stop_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def stop: Rep[Boolean] = hashJoinAnti_Field_Stop[A, B, C](self)(typeA, typeB, typeC)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = hashJoinAnti_Field_Child_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def child: Rep[Operator[Any]] = hashJoinAnti_Field_Child[A, B, C](self)(typeA, typeB, typeC)
  }
  object HashJoinAnti {

  }
  // constructors
  def __newHashJoinAnti[A, B, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]])(joinCond: Rep[((A, B) => Boolean)])(leftHash: Rep[(A => C)])(rightHash: Rep[(B => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashJoinAnti[A, B, C]] = hashJoinAntiNew[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)(typeA, typeB, typeC)
  // case classes
  case class HashJoinAntiNew[A, B, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends ConstructorDef[HashJoinAnti[A, B, C]](List(typeA, typeB, typeC), "HashJoinAnti", List(List(leftParent, rightParent), List(joinCond), List(leftHash), List(rightHash))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinAntiOpen[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinAntiReset[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinAntiNext[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinAntiConsume[A, B, C](self: Rep[HashJoinAnti[A, B, C]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinAnti_Field_ExpectedSize[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_KeySet_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Set[C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Set[C]](self, "keySet", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinAnti_Field_KeySet[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Set[C]](self, "keySet") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinAnti_Field_Hm[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[HashMap[C, ArrayBuffer[A]]](self, "hm") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_Mode_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Int])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Int](self, "mode", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinAnti_Field_Mode[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Int](self, "mode") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinAnti_Field_RightHash[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(B => C)](self, "rightHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_LeftHash[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(A => C)](self, "leftHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_JoinCond[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[((A, B) => Boolean)](self, "joinCond") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_RightParent[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[B]](self, "rightParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_LeftParent[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[A]](self, "leftParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class HashJoinAnti_Field_Stop_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinAnti_Field_Stop[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class HashJoinAnti_Field_Child_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class HashJoinAnti_Field_Child[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  // method definitions
  def hashJoinAntiNew[A, B, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashJoinAnti[A, B, C]] = HashJoinAntiNew[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)
  def hashJoinAntiOpen[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAntiOpen[A, B, C](self)
  def hashJoinAntiReset[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAntiReset[A, B, C](self)
  def hashJoinAntiNext[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAntiNext[A, B, C](self)
  def hashJoinAntiConsume[A, B, C](self: Rep[HashJoinAnti[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAntiConsume[A, B, C](self, tuple)
  def hashJoinAnti_Field_ExpectedSize[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = HashJoinAnti_Field_ExpectedSize[A, B, C](self)
  def hashJoinAnti_Field_KeySet_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Set[C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAnti_Field_KeySet_$eq[A, B, C](self, x$1)
  def hashJoinAnti_Field_KeySet[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Set[C]] = HashJoinAnti_Field_KeySet[A, B, C](self)
  def hashJoinAnti_Field_Hm[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashMap[C, ArrayBuffer[A]]] = HashJoinAnti_Field_Hm[A, B, C](self)
  def hashJoinAnti_Field_Mode_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAnti_Field_Mode_$eq[A, B, C](self, x$1)
  def hashJoinAnti_Field_Mode[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = HashJoinAnti_Field_Mode[A, B, C](self)
  def hashJoinAnti_Field_RightHash[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = HashJoinAnti_Field_RightHash[A, B, C](self)
  def hashJoinAnti_Field_LeftHash[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = HashJoinAnti_Field_LeftHash[A, B, C](self)
  def hashJoinAnti_Field_JoinCond[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = HashJoinAnti_Field_JoinCond[A, B, C](self)
  def hashJoinAnti_Field_RightParent[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = HashJoinAnti_Field_RightParent[A, B, C](self)
  def hashJoinAnti_Field_LeftParent[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = HashJoinAnti_Field_LeftParent[A, B, C](self)
  def hashJoinAnti_Field_Stop_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAnti_Field_Stop_$eq[A, B, C](self, x$1)
  def hashJoinAnti_Field_Stop[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Boolean] = HashJoinAnti_Field_Stop[A, B, C](self)
  def hashJoinAnti_Field_Child_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = HashJoinAnti_Field_Child_$eq[A, B, C](self, x$1)
  def hashJoinAnti_Field_Child[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] = HashJoinAnti_Field_Child[A, B, C](self)
  type HashJoinAnti[A, B, C] = ch.epfl.data.legobase.queryengine.push.HashJoinAnti[A, B, C]
}
trait HashJoinAntiImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait HashJoinAntiImplementations { this: DeepDSL =>
  override def hashJoinAntiOpen[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.leftParent.child_$eq(self);
      self.leftParent.open();
      self.rightParent.child_$eq(self);
      self.rightParent.open()
    }
  }
  override def hashJoinAntiReset[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.rightParent.reset();
      self.leftParent.reset();
      self.hm.clear()
    }
  }
  override def hashJoinAntiNext[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    {
      self.leftParent.next();
      self.mode_$eq(unit(1));
      self.rightParent.next();
      self.keySet_$eq(Set.apply[C](self.hm.keySet.toSeq));
      __whileDo(self.stop.unary_$bang.$amp$amp(infix_$bang$eq(self.hm.size, unit(0))), {
        val key: this.Rep[C] = self.keySet.head;
        self.keySet.remove(key);
        val elems: this.Rep[Option[scala.collection.mutable.ArrayBuffer[A]]] = self.hm.remove(key);
        var i: this.Var[Int] = __newVar(unit(0));
        val len: this.Rep[Int] = elems.get.size;
        val l: this.Rep[scala.collection.mutable.ArrayBuffer[A]] = elems.get;
        __whileDo(__readVar(i).$less(len), {
          val e: this.Rep[A] = l.apply(__readVar(i));
          self.child.consume(infix_asInstanceOf[ch.epfl.data.pardis.shallow.Record](e));
          __assign(i, __readVar(i).$plus(unit(1)))
        })
      })
    }
  }
  override def hashJoinAntiConsume[A, B, C](self: Rep[HashJoinAnti[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    __ifThenElse(infix_$eq$eq(self.mode, unit(0)), {
      val t: this.Rep[A] = infix_asInstanceOf[A](tuple);
      val k: this.Rep[C] = __app(self.leftHash).apply(t);
      val v: this.Rep[scala.collection.mutable.ArrayBuffer[A]] = self.hm.getOrElseUpdate(k, ArrayBuffer.apply[A]());
      v.append(t)
    }, {
      val t: this.Rep[B] = infix_asInstanceOf[B](tuple);
      val k: this.Rep[C] = __app(self.rightHash).apply(t);
      __ifThenElse(self.hm.contains(k), {
        val elems: this.Rep[scala.collection.mutable.ArrayBuffer[A]] = self.hm.apply(k);
        var removed: this.Var[Int] = __newVar(unit(0));
        var i: this.Var[Int] = __newVar(unit(0));
        val len: this.Rep[Int] = elems.size;
        __whileDo(__readVar(i).$less(len), {
          var idx: this.Var[Int] = __newVar(__readVar(i).$minus(__readVar(removed)));
          val e: this.Rep[A] = elems.apply(__readVar(idx));
          __ifThenElse(__app(self.joinCond).apply(e, t), {
            elems.remove(__readVar(idx));
            __assign(removed, __readVar(removed).$plus(unit(1)))
          }, unit(()));
          __assign(i, __readVar(i).$plus(unit(1)))
        })
      }, unit(()))
    })
  }
}
trait HashJoinAntiPartialEvaluation extends HashJoinAntiComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def hashJoinAnti_Field_RightHash[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = self match {
    case Def(node: HashJoinAntiNew[_, _, _]) => node.rightHash
    case _                                   => super.hashJoinAnti_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinAnti_Field_LeftHash[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = self match {
    case Def(node: HashJoinAntiNew[_, _, _]) => node.leftHash
    case _                                   => super.hashJoinAnti_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinAnti_Field_JoinCond[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = self match {
    case Def(node: HashJoinAntiNew[_, _, _]) => node.joinCond
    case _                                   => super.hashJoinAnti_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinAnti_Field_RightParent[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = self match {
    case Def(node: HashJoinAntiNew[_, _, _]) => node.rightParent
    case _                                   => super.hashJoinAnti_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
  }
  override def hashJoinAnti_Field_LeftParent[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = self match {
    case Def(node: HashJoinAntiNew[_, _, _]) => node.leftParent
    case _                                   => super.hashJoinAnti_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
  }

  // Mutable field inlining 
  override def hashJoinAnti_Field_Mode_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "mode") = x$1
    unit(())
  }

  override def hashJoinAnti_Field_Mode[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] =
    mutableFieldValues.get(self -> "mode").getOrElse(unit(0)).asInstanceOf[Rep[Int]]
  override def hashJoinAnti_Field_Child_$eq[A, B, C](self: Rep[HashJoinAnti[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def hashJoinAnti_Field_Child[A, B, C](self: Rep[HashJoinAnti[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait HashJoinAntiComponent extends HashJoinAntiOps with HashJoinAntiImplicits { this: DeepDSL => }
trait ViewOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class ViewOpType[A](typeA: TypeRep[A]) extends TypeRep[ViewOp[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = ViewOpType(newArguments(0).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    val name = s"ViewOp[${typeA.name}]"
    val typeArguments = List(typeA)

    val typeTag = scala.reflect.runtime.universe.typeTag[ViewOp[A]]
  }
  implicit def typeViewOp[A: TypeRep] = ViewOpType(implicitly[TypeRep[A]])
  implicit class ViewOpRep[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]) {
    def open(): Rep[Unit] = viewOpOpen[A](self)(typeA, evidence$1)
    def reset(): Rep[Unit] = viewOpReset[A](self)(typeA, evidence$1)
    def next(): Rep[Unit] = viewOpNext[A](self)(typeA, evidence$1)
    def consume(tuple: Rep[Record]): Rep[Unit] = viewOpConsume[A](self, tuple)(typeA, evidence$1)
    def expectedSize: Rep[Int] = viewOp_Field_ExpectedSize[A](self)(typeA)
    def table: Rep[Array[A]] = viewOp_Field_Table[A](self)(typeA)
    def size_=(x$1: Rep[Int]): Rep[Unit] = viewOp_Field_Size_$eq[A](self, x$1)(typeA)
    def size: Rep[Int] = viewOp_Field_Size[A](self)(typeA)
    def evidence$1: Rep[Manifest[A]] = viewOp_Field_Evidence$1[A](self)(typeA)
    def parent: Rep[Operator[A]] = viewOp_Field_Parent[A](self)(typeA)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = viewOp_Field_Stop_$eq[A](self, x$1)(typeA)
    def stop: Rep[Boolean] = viewOp_Field_Stop[A](self)(typeA)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = viewOp_Field_Child_$eq[A](self, x$1)(typeA)
    def child: Rep[Operator[Any]] = viewOp_Field_Child[A](self)(typeA)
  }
  object ViewOp {

  }
  // constructors
  def __newViewOp[A](parent: Rep[Operator[A]])(implicit evidence$1: Manifest[A], typeA: TypeRep[A]): Rep[ViewOp[A]] = viewOpNew[A](parent)(typeA, evidence$1)
  // case classes
  case class ViewOpNew[A](parent: Rep[Operator[A]])(implicit val typeA: TypeRep[A], val evidence$1: Manifest[A]) extends ConstructorDef[ViewOp[A]](List(typeA), "ViewOp", List(List(parent))) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ViewOpOpen[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A], val evidence$1: Manifest[A]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ViewOpReset[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A], val evidence$1: Manifest[A]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ViewOpNext[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A], val evidence$1: Manifest[A]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A] _)
  }

  case class ViewOpConsume[A](self: Rep[ViewOp[A]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val evidence$1: Manifest[A]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ViewOp_Field_ExpectedSize[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class ViewOp_Field_Table[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Array[A]](self, "table") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class ViewOp_Field_Size_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Int])(implicit val typeA: TypeRep[A]) extends FieldSetter[Int](self, "size", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ViewOp_Field_Size[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Int](self, "size") {
    override def curriedConstructor = (copy[A] _)
  }

  case class ViewOp_Field_Evidence$1[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Manifest[A]](self, "evidence$1") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class ViewOp_Field_Parent[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldDef[Operator[A]](self, "parent") {
    override def curriedConstructor = (copy[A] _)
    override def isPure = true

  }

  case class ViewOp_Field_Stop_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ViewOp_Field_Stop[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A] _)
  }

  case class ViewOp_Field_Child_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A] _).curried
  }

  case class ViewOp_Field_Child[A](self: Rep[ViewOp[A]])(implicit val typeA: TypeRep[A]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A] _)
  }

  // method definitions
  def viewOpNew[A](parent: Rep[Operator[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[ViewOp[A]] = ViewOpNew[A](parent)
  def viewOpOpen[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = ViewOpOpen[A](self)
  def viewOpReset[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = ViewOpReset[A](self)
  def viewOpNext[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = ViewOpNext[A](self)
  def viewOpConsume[A](self: Rep[ViewOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = ViewOpConsume[A](self, tuple)
  def viewOp_Field_ExpectedSize[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = ViewOp_Field_ExpectedSize[A](self)
  def viewOp_Field_Table[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Array[A]] = ViewOp_Field_Table[A](self)
  def viewOp_Field_Size_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Int])(implicit typeA: TypeRep[A]): Rep[Unit] = ViewOp_Field_Size_$eq[A](self, x$1)
  def viewOp_Field_Size[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Int] = ViewOp_Field_Size[A](self)
  def viewOp_Field_Evidence$1[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Manifest[A]] = ViewOp_Field_Evidence$1[A](self)
  def viewOp_Field_Parent[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = ViewOp_Field_Parent[A](self)
  def viewOp_Field_Stop_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A]): Rep[Unit] = ViewOp_Field_Stop_$eq[A](self, x$1)
  def viewOp_Field_Stop[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Boolean] = ViewOp_Field_Stop[A](self)
  def viewOp_Field_Child_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = ViewOp_Field_Child_$eq[A](self, x$1)
  def viewOp_Field_Child[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] = ViewOp_Field_Child[A](self)
  type ViewOp[A] = ch.epfl.data.legobase.queryengine.push.ViewOp[A]
}
trait ViewOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait ViewOpImplementations { this: DeepDSL =>
  override def viewOpOpen[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = {
    {
      self.parent.child_$eq(self);
      self.parent.open()
    }
  }
  override def viewOpReset[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = {
    unit(())
  }
  override def viewOpNext[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = {
    {
      self.parent.next();
      var idx: this.Var[Int] = __newVar(unit(0));
      __whileDo(self.stop.unary_$bang.$amp$amp(__readVar(idx).$less(self.size)), {
        val e: this.Rep[A] = self.table.apply(__readVar(idx));
        __assign(idx, __readVar(idx).$plus(unit(1)));
        self.child.consume(infix_asInstanceOf[ch.epfl.data.pardis.shallow.Record](e))
      })
    }
  }
  override def viewOpConsume[A](self: Rep[ViewOp[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A], evidence$1: Manifest[A]): Rep[Unit] = {
    {
      self.table.update(self.size, infix_asInstanceOf[A](tuple));
      self.size_$eq(self.size.$plus(unit(1)))
    }
  }
}
trait ViewOpPartialEvaluation extends ViewOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def viewOp_Field_Parent[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[A]] = self match {
    case Def(node: ViewOpNew[_]) => node.parent
    case _                       => super.viewOp_Field_Parent[A](self)(typeA)
  }

  // Mutable field inlining 
  override def viewOp_Field_Child_$eq[A](self: Rep[ViewOp[A]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def viewOp_Field_Child[A](self: Rep[ViewOp[A]])(implicit typeA: TypeRep[A]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait ViewOpComponent extends ViewOpOps with ViewOpImplicits { this: DeepDSL => }
trait LeftOuterJoinOpOps extends Base { this: DeepDSL =>
  // Type representation
  case class LeftOuterJoinOpType[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]) extends TypeRep[LeftOuterJoinOp[A, B, C]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = LeftOuterJoinOpType(newArguments(0).asInstanceOf[TypeRep[_ <: ch.epfl.data.pardis.shallow.Record]], newArguments(1).asInstanceOf[TypeRep[_ <: ch.epfl.data.pardis.shallow.Record]], newArguments(2).asInstanceOf[TypeRep[_]])
    private implicit val tagA = typeA.typeTag
    private implicit val tagB = typeB.typeTag
    private implicit val tagC = typeC.typeTag
    val name = s"LeftOuterJoinOp[${typeA.name}, ${typeB.name}, ${typeC.name}]"
    val typeArguments = List(typeA, typeB, typeC)

    val typeTag = scala.reflect.runtime.universe.typeTag[LeftOuterJoinOp[A, B, C]]
  }
  implicit def typeLeftOuterJoinOp[A <: ch.epfl.data.pardis.shallow.Record: TypeRep, B <: ch.epfl.data.pardis.shallow.Record: TypeRep, C: TypeRep] = LeftOuterJoinOpType(implicitly[TypeRep[A]], implicitly[TypeRep[B]], implicitly[TypeRep[C]])
  implicit class LeftOuterJoinOpRep[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]) {
    def open(): Rep[Unit] = leftOuterJoinOpOpen[A, B, C](self)(typeA, typeB, typeC, evidence$2)
    def next(): Rep[Unit] = leftOuterJoinOpNext[A, B, C](self)(typeA, typeB, typeC, evidence$2)
    def reset(): Rep[Unit] = leftOuterJoinOpReset[A, B, C](self)(typeA, typeB, typeC, evidence$2)
    def consume(tuple: Rep[Record]): Rep[Unit] = leftOuterJoinOpConsume[A, B, C](self, tuple)(typeA, typeB, typeC, evidence$2)
    def expectedSize: Rep[Int] = leftOuterJoinOp_Field_ExpectedSize[A, B, C](self)(typeA, typeB, typeC)
    def defaultB: Rep[B] = leftOuterJoinOp_Field_DefaultB[A, B, C](self)(typeA, typeB, typeC)
    def hm: Rep[HashMap[C, ArrayBuffer[B]]] = leftOuterJoinOp_Field_Hm[A, B, C](self)(typeA, typeB, typeC)
    def mode_=(x$1: Rep[Int]): Rep[Unit] = leftOuterJoinOp_Field_Mode_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def mode: Rep[Int] = leftOuterJoinOp_Field_Mode[A, B, C](self)(typeA, typeB, typeC)
    def evidence$2: Rep[Manifest[B]] = leftOuterJoinOp_Field_Evidence$2[A, B, C](self)(typeA, typeB, typeC)
    def rightHash: Rep[(B => C)] = leftOuterJoinOp_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
    def leftHash: Rep[(A => C)] = leftOuterJoinOp_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
    def joinCond: Rep[((A, B) => Boolean)] = leftOuterJoinOp_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
    def rightParent: Rep[Operator[B]] = leftOuterJoinOp_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
    def leftParent: Rep[Operator[A]] = leftOuterJoinOp_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
    def stop_=(x$1: Rep[Boolean]): Rep[Unit] = leftOuterJoinOp_Field_Stop_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def stop: Rep[Boolean] = leftOuterJoinOp_Field_Stop[A, B, C](self)(typeA, typeB, typeC)
    def child_=(x$1: Rep[Operator[Any]]): Rep[Unit] = leftOuterJoinOp_Field_Child_$eq[A, B, C](self, x$1)(typeA, typeB, typeC)
    def child: Rep[Operator[Any]] = leftOuterJoinOp_Field_Child[A, B, C](self)(typeA, typeB, typeC)
  }
  object LeftOuterJoinOp {

  }
  // constructors
  def __newLeftOuterJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]])(joinCond: Rep[((A, B) => Boolean)])(leftHash: Rep[(A => C)])(rightHash: Rep[(B => C)])(implicit evidence$2: Manifest[B], typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[LeftOuterJoinOp[A, B, C]] = leftOuterJoinOpNew[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)(typeA, typeB, typeC, evidence$2)
  // case classes
  case class LeftOuterJoinOpNew[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C], val evidence$2: Manifest[B]) extends ConstructorDef[LeftOuterJoinOp[A, B, C]](List(typeA, typeB, typeC), "LeftOuterJoinOp", List(List(leftParent, rightParent), List(joinCond), List(leftHash), List(rightHash))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftOuterJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C], val evidence$2: Manifest[B]) extends FunctionDef[Unit](Some(self), "open", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftOuterJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C], val evidence$2: Manifest[B]) extends FunctionDef[Unit](Some(self), "next", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftOuterJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C], val evidence$2: Manifest[B]) extends FunctionDef[Unit](Some(self), "reset", List(List())) {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftOuterJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], tuple: Rep[Record])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C], val evidence$2: Manifest[B]) extends FunctionDef[Unit](Some(self), "consume", List(List(tuple))) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftOuterJoinOp_Field_ExpectedSize[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Int](self, "expectedSize") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_DefaultB[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[B](self, "defaultB") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_Hm[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[HashMap[C, ArrayBuffer[B]]](self, "hm") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Int])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Int](self, "mode", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftOuterJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Int](self, "mode") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftOuterJoinOp_Field_Evidence$2[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Manifest[B]](self, "evidence$2") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_RightHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(B => C)](self, "rightHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_LeftHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[(A => C)](self, "leftHash") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[((A, B) => Boolean)](self, "joinCond") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[B]](self, "rightParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldDef[Operator[A]](self, "leftParent") {
    override def curriedConstructor = (copy[A, B, C] _)
    override def isPure = true

  }

  case class LeftOuterJoinOp_Field_Stop_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Boolean])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Boolean](self, "stop", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftOuterJoinOp_Field_Stop[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Boolean](self, "stop") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  case class LeftOuterJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldSetter[Operator[Any]](self, "child", x$1) {
    override def curriedConstructor = (copy[A, B, C] _).curried
  }

  case class LeftOuterJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit val typeA: TypeRep[A], val typeB: TypeRep[B], val typeC: TypeRep[C]) extends FieldGetter[Operator[Any]](self, "child") {
    override def curriedConstructor = (copy[A, B, C] _)
  }

  // method definitions
  def leftOuterJoinOpNew[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](leftParent: Rep[Operator[A]], rightParent: Rep[Operator[B]], joinCond: Rep[((A, B) => Boolean)], leftHash: Rep[((A) => C)], rightHash: Rep[((B) => C)])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[LeftOuterJoinOp[A, B, C]] = LeftOuterJoinOpNew[A, B, C](leftParent, rightParent, joinCond, leftHash, rightHash)
  def leftOuterJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = LeftOuterJoinOpOpen[A, B, C](self)
  def leftOuterJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = LeftOuterJoinOpNext[A, B, C](self)
  def leftOuterJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = LeftOuterJoinOpReset[A, B, C](self)
  def leftOuterJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = LeftOuterJoinOpConsume[A, B, C](self, tuple)
  def leftOuterJoinOp_Field_ExpectedSize[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = LeftOuterJoinOp_Field_ExpectedSize[A, B, C](self)
  def leftOuterJoinOp_Field_DefaultB[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[B] = LeftOuterJoinOp_Field_DefaultB[A, B, C](self)
  def leftOuterJoinOp_Field_Hm[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[HashMap[C, ArrayBuffer[B]]] = LeftOuterJoinOp_Field_Hm[A, B, C](self)
  def leftOuterJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftOuterJoinOp_Field_Mode_$eq[A, B, C](self, x$1)
  def leftOuterJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] = LeftOuterJoinOp_Field_Mode[A, B, C](self)
  def leftOuterJoinOp_Field_Evidence$2[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Manifest[B]] = LeftOuterJoinOp_Field_Evidence$2[A, B, C](self)
  def leftOuterJoinOp_Field_RightHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = LeftOuterJoinOp_Field_RightHash[A, B, C](self)
  def leftOuterJoinOp_Field_LeftHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = LeftOuterJoinOp_Field_LeftHash[A, B, C](self)
  def leftOuterJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = LeftOuterJoinOp_Field_JoinCond[A, B, C](self)
  def leftOuterJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = LeftOuterJoinOp_Field_RightParent[A, B, C](self)
  def leftOuterJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = LeftOuterJoinOp_Field_LeftParent[A, B, C](self)
  def leftOuterJoinOp_Field_Stop_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Boolean])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftOuterJoinOp_Field_Stop_$eq[A, B, C](self, x$1)
  def leftOuterJoinOp_Field_Stop[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Boolean] = LeftOuterJoinOp_Field_Stop[A, B, C](self)
  def leftOuterJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = LeftOuterJoinOp_Field_Child_$eq[A, B, C](self, x$1)
  def leftOuterJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] = LeftOuterJoinOp_Field_Child[A, B, C](self)
  type LeftOuterJoinOp[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C] = ch.epfl.data.legobase.queryengine.push.LeftOuterJoinOp[A, B, C]
}
trait LeftOuterJoinOpImplicits { this: DeepDSL =>
  // Add implicit conversions here!
}
trait LeftOuterJoinOpImplementations { this: DeepDSL =>
  override def leftOuterJoinOpOpen[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = {
    {
      self.leftParent.child_$eq(self);
      self.leftParent.open();
      self.rightParent.child_$eq(self);
      self.rightParent.open()
    }
  }
  override def leftOuterJoinOpNext[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = {
    {
      self.rightParent.next();
      self.mode_$eq(unit(1));
      self.leftParent.next()
    }
  }
  override def leftOuterJoinOpReset[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = {
    {
      self.rightParent.reset();
      self.leftParent.reset();
      self.hm.clear()
    }
  }
  override def leftOuterJoinOpConsume[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], tuple: Rep[Record])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C], evidence$2: Manifest[B]): Rep[Unit] = {
    __ifThenElse(infix_$eq$eq(self.mode, unit(0)), {
      val k: this.Rep[C] = __app(self.rightHash).apply(infix_asInstanceOf[B](tuple));
      val v: this.Rep[scala.collection.mutable.ArrayBuffer[B]] = self.hm.getOrElseUpdate(k, ArrayBuffer.apply[B]());
      v.append(infix_asInstanceOf[B](tuple))
    }, {
      val k: this.Rep[C] = __app(self.leftHash).apply(infix_asInstanceOf[A](tuple));
      __ifThenElse(self.hm.contains(k), {
        val tmpBuffer: this.Rep[scala.collection.mutable.ArrayBuffer[B]] = self.hm.apply(k);
        var tmpCount: this.Var[Int] = __newVar(unit(0));
        val size: this.Rep[Int] = tmpBuffer.size;
        var break: this.Var[Boolean] = __newVar(unit(false));
        __whileDo(self.stop.unary_$bang.$amp$amp(__readVar(break).unary_$bang), {
          val bufElem: this.Rep[B] = tmpBuffer.apply(__readVar(tmpCount));
          val elem: this.Rep[ch.epfl.data.pardis.shallow.DynamicCompositeRecord[A, B]] = __ifThenElse(__app(self.joinCond).apply(infix_asInstanceOf[A](tuple), bufElem), RecordOps[A](infix_asInstanceOf[A](tuple)).concatenateDynamic[B](bufElem, unit(""), unit("")), RecordOps[A](infix_asInstanceOf[A](tuple)).concatenateDynamic[B](self.defaultB, unit(""), unit("")));
          self.child.consume(elem);
          __ifThenElse(__readVar(tmpCount).$plus(unit(1)).$greater$eq(size), __assign(break, unit(true)), unit(()));
          __assign(tmpCount, __readVar(tmpCount).$plus(unit(1)))
        })
      }, self.child.consume(RecordOps[A](infix_asInstanceOf[A](tuple)).concatenateDynamic[B](self.defaultB, unit(""), unit(""))))
    })
  }
}
trait LeftOuterJoinOpPartialEvaluation extends LeftOuterJoinOpComponent with BasePartialEvaluation { this: DeepDSL =>
  // Immutable field inlining 
  override def leftOuterJoinOp_Field_RightHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(B => C)] = self match {
    case Def(node: LeftOuterJoinOpNew[_, _, _]) => node.rightHash
    case _                                      => super.leftOuterJoinOp_Field_RightHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftOuterJoinOp_Field_LeftHash[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[(A => C)] = self match {
    case Def(node: LeftOuterJoinOpNew[_, _, _]) => node.leftHash
    case _                                      => super.leftOuterJoinOp_Field_LeftHash[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftOuterJoinOp_Field_JoinCond[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[((A, B) => Boolean)] = self match {
    case Def(node: LeftOuterJoinOpNew[_, _, _]) => node.joinCond
    case _                                      => super.leftOuterJoinOp_Field_JoinCond[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftOuterJoinOp_Field_RightParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[B]] = self match {
    case Def(node: LeftOuterJoinOpNew[_, _, _]) => node.rightParent
    case _                                      => super.leftOuterJoinOp_Field_RightParent[A, B, C](self)(typeA, typeB, typeC)
  }
  override def leftOuterJoinOp_Field_LeftParent[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[A]] = self match {
    case Def(node: LeftOuterJoinOpNew[_, _, _]) => node.leftParent
    case _                                      => super.leftOuterJoinOp_Field_LeftParent[A, B, C](self)(typeA, typeB, typeC)
  }

  // Mutable field inlining 
  override def leftOuterJoinOp_Field_Mode_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Int])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "mode") = x$1
    unit(())
  }

  override def leftOuterJoinOp_Field_Mode[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Int] =
    mutableFieldValues.get(self -> "mode").getOrElse(unit(0)).asInstanceOf[Rep[Int]]
  override def leftOuterJoinOp_Field_Child_$eq[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]], x$1: Rep[Operator[Any]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Unit] = {
    mutableFieldValues(self -> "child") = x$1
    unit(())
  }

  override def leftOuterJoinOp_Field_Child[A <: ch.epfl.data.pardis.shallow.Record, B <: ch.epfl.data.pardis.shallow.Record, C](self: Rep[LeftOuterJoinOp[A, B, C]])(implicit typeA: TypeRep[A], typeB: TypeRep[B], typeC: TypeRep[C]): Rep[Operator[Any]] =
    mutableFieldValues(self -> "child").asInstanceOf[Rep[Operator[Any]]]
  // Pure function partial evaluation
}
trait LeftOuterJoinOpComponent extends LeftOuterJoinOpOps with LeftOuterJoinOpImplicits { this: DeepDSL => }
trait OperatorDynamicDispatch extends OperatorComponent { this: DeepDSL =>
  override def operatorOpen[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = self match {
    case Def(node: ScanOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ScanOpNew[T1]]
      scanOpOpen[T1](self.asInstanceOf[Rep[ScanOp[T1]]])(newNode.typeA)
    case Def(node: PrintOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[PrintOpNew[T1]]
      printOpOpen[T1](self.asInstanceOf[Rep[PrintOp[T1]]])(newNode.typeA)
    case Def(node: SelectOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SelectOpNew[T1]]
      selectOpOpen[T1](self.asInstanceOf[Rep[SelectOp[T1]]])(newNode.typeA)
    case Def(node: AggOpNew[_, _]) =>
      type T1 = Any
      type T2 = Any
      val newNode = node.asInstanceOf[AggOpNew[T1, T2]]
      aggOpOpen[T1, T2](self.asInstanceOf[Rep[AggOp[T1, T2]]])(newNode.typeA, newNode.typeB)
    case Def(node: MapOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[MapOpNew[T1]]
      mapOpOpen[T1](self.asInstanceOf[Rep[MapOp[T1]]])(newNode.typeA)
    case Def(node: SortOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SortOpNew[T1]]
      sortOpOpen[T1](self.asInstanceOf[Rep[SortOp[T1]]])(newNode.typeA)
    case Def(node: HashJoinOpNew1[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew1[T1, T2, T3]]
      hashJoinOpOpen[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: HashJoinOpNew2[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew2[T1, T2, T3]]
      hashJoinOpOpen[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: WindowOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[WindowOpNew[T1, T2, T3]]
      windowOpOpen[T1, T2, T3](self.asInstanceOf[Rep[WindowOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[LeftHashSemiJoinOpNew[T1, T2, T3]]
      leftHashSemiJoinOpOpen[T1, T2, T3](self.asInstanceOf[Rep[LeftHashSemiJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: NestedLoopsJoinOpNew[_, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      val newNode = node.asInstanceOf[NestedLoopsJoinOpNew[T1, T2]]
      nestedLoopsJoinOpOpen[T1, T2](self.asInstanceOf[Rep[NestedLoopsJoinOp[T1, T2]]])(newNode.typeA, newNode.typeB)
    case Def(node: SubquerySingleResultNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SubquerySingleResultNew[T1]]
      subquerySingleResultOpen[T1](self.asInstanceOf[Rep[SubquerySingleResult[T1]]])(newNode.typeA)
    case Def(node: HashJoinAntiNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinAntiNew[T1, T2, T3]]
      hashJoinAntiOpen[T1, T2, T3](self.asInstanceOf[Rep[HashJoinAnti[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: ViewOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ViewOpNew[T1]]
      viewOpOpen[T1](self.asInstanceOf[Rep[ViewOp[T1]]])(newNode.typeA, newNode.evidence$1)
    case Def(node: LeftOuterJoinOpNew[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[LeftOuterJoinOpNew[T1, T2, T3]]
      leftOuterJoinOpOpen[T1, T2, T3](self.asInstanceOf[Rep[LeftOuterJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC, newNode.evidence$2)
    case _ => super.operatorOpen[A](self)(typeA)
  }
  override def operatorNext[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = self match {
    case Def(node: ScanOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ScanOpNew[T1]]
      scanOpNext[T1](self.asInstanceOf[Rep[ScanOp[T1]]])(newNode.typeA)
    case Def(node: PrintOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[PrintOpNew[T1]]
      printOpNext[T1](self.asInstanceOf[Rep[PrintOp[T1]]])(newNode.typeA)
    case Def(node: SelectOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SelectOpNew[T1]]
      selectOpNext[T1](self.asInstanceOf[Rep[SelectOp[T1]]])(newNode.typeA)
    case Def(node: AggOpNew[_, _]) =>
      type T1 = Any
      type T2 = Any
      val newNode = node.asInstanceOf[AggOpNew[T1, T2]]
      aggOpNext[T1, T2](self.asInstanceOf[Rep[AggOp[T1, T2]]])(newNode.typeA, newNode.typeB)
    case Def(node: MapOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[MapOpNew[T1]]
      mapOpNext[T1](self.asInstanceOf[Rep[MapOp[T1]]])(newNode.typeA)
    case Def(node: SortOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SortOpNew[T1]]
      sortOpNext[T1](self.asInstanceOf[Rep[SortOp[T1]]])(newNode.typeA)
    case Def(node: HashJoinOpNew1[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew1[T1, T2, T3]]
      hashJoinOpNext[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: HashJoinOpNew2[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew2[T1, T2, T3]]
      hashJoinOpNext[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: WindowOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[WindowOpNew[T1, T2, T3]]
      windowOpNext[T1, T2, T3](self.asInstanceOf[Rep[WindowOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[LeftHashSemiJoinOpNew[T1, T2, T3]]
      leftHashSemiJoinOpNext[T1, T2, T3](self.asInstanceOf[Rep[LeftHashSemiJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: NestedLoopsJoinOpNew[_, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      val newNode = node.asInstanceOf[NestedLoopsJoinOpNew[T1, T2]]
      nestedLoopsJoinOpNext[T1, T2](self.asInstanceOf[Rep[NestedLoopsJoinOp[T1, T2]]])(newNode.typeA, newNode.typeB)
    case Def(node: SubquerySingleResultNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SubquerySingleResultNew[T1]]
      subquerySingleResultNext[T1](self.asInstanceOf[Rep[SubquerySingleResult[T1]]])(newNode.typeA)
    case Def(node: HashJoinAntiNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinAntiNew[T1, T2, T3]]
      hashJoinAntiNext[T1, T2, T3](self.asInstanceOf[Rep[HashJoinAnti[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: ViewOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ViewOpNew[T1]]
      viewOpNext[T1](self.asInstanceOf[Rep[ViewOp[T1]]])(newNode.typeA, newNode.evidence$1)
    case Def(node: LeftOuterJoinOpNew[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[LeftOuterJoinOpNew[T1, T2, T3]]
      leftOuterJoinOpNext[T1, T2, T3](self.asInstanceOf[Rep[LeftOuterJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC, newNode.evidence$2)
    case _ => super.operatorNext[A](self)(typeA)
  }
  override def operatorReset[A](self: Rep[Operator[A]])(implicit typeA: TypeRep[A]): Rep[Unit] = self match {
    case Def(node: ScanOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ScanOpNew[T1]]
      scanOpReset[T1](self.asInstanceOf[Rep[ScanOp[T1]]])(newNode.typeA)
    case Def(node: PrintOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[PrintOpNew[T1]]
      printOpReset[T1](self.asInstanceOf[Rep[PrintOp[T1]]])(newNode.typeA)
    case Def(node: SelectOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SelectOpNew[T1]]
      selectOpReset[T1](self.asInstanceOf[Rep[SelectOp[T1]]])(newNode.typeA)
    case Def(node: AggOpNew[_, _]) =>
      type T1 = Any
      type T2 = Any
      val newNode = node.asInstanceOf[AggOpNew[T1, T2]]
      aggOpReset[T1, T2](self.asInstanceOf[Rep[AggOp[T1, T2]]])(newNode.typeA, newNode.typeB)
    case Def(node: MapOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[MapOpNew[T1]]
      mapOpReset[T1](self.asInstanceOf[Rep[MapOp[T1]]])(newNode.typeA)
    case Def(node: SortOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SortOpNew[T1]]
      sortOpReset[T1](self.asInstanceOf[Rep[SortOp[T1]]])(newNode.typeA)
    case Def(node: HashJoinOpNew1[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew1[T1, T2, T3]]
      hashJoinOpReset[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: HashJoinOpNew2[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew2[T1, T2, T3]]
      hashJoinOpReset[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: WindowOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[WindowOpNew[T1, T2, T3]]
      windowOpReset[T1, T2, T3](self.asInstanceOf[Rep[WindowOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[LeftHashSemiJoinOpNew[T1, T2, T3]]
      leftHashSemiJoinOpReset[T1, T2, T3](self.asInstanceOf[Rep[LeftHashSemiJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: NestedLoopsJoinOpNew[_, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      val newNode = node.asInstanceOf[NestedLoopsJoinOpNew[T1, T2]]
      nestedLoopsJoinOpReset[T1, T2](self.asInstanceOf[Rep[NestedLoopsJoinOp[T1, T2]]])(newNode.typeA, newNode.typeB)
    case Def(node: SubquerySingleResultNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SubquerySingleResultNew[T1]]
      subquerySingleResultReset[T1](self.asInstanceOf[Rep[SubquerySingleResult[T1]]])(newNode.typeA)
    case Def(node: HashJoinAntiNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinAntiNew[T1, T2, T3]]
      hashJoinAntiReset[T1, T2, T3](self.asInstanceOf[Rep[HashJoinAnti[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: ViewOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ViewOpNew[T1]]
      viewOpReset[T1](self.asInstanceOf[Rep[ViewOp[T1]]])(newNode.typeA, newNode.evidence$1)
    case Def(node: LeftOuterJoinOpNew[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[LeftOuterJoinOpNew[T1, T2, T3]]
      leftOuterJoinOpReset[T1, T2, T3](self.asInstanceOf[Rep[LeftOuterJoinOp[T1, T2, T3]]])(newNode.typeA, newNode.typeB, newNode.typeC, newNode.evidence$2)
    case _ => super.operatorReset[A](self)(typeA)
  }
  override def operatorConsume[A](self: Rep[Operator[A]], tuple: Rep[Record])(implicit typeA: TypeRep[A]): Rep[Unit] = self match {
    case Def(node: ScanOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ScanOpNew[T1]]
      scanOpConsume[T1](self.asInstanceOf[Rep[ScanOp[T1]]], tuple)(newNode.typeA)
    case Def(node: PrintOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[PrintOpNew[T1]]
      printOpConsume[T1](self.asInstanceOf[Rep[PrintOp[T1]]], tuple)(newNode.typeA)
    case Def(node: SelectOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SelectOpNew[T1]]
      selectOpConsume[T1](self.asInstanceOf[Rep[SelectOp[T1]]], tuple)(newNode.typeA)
    case Def(node: AggOpNew[_, _]) =>
      type T1 = Any
      type T2 = Any
      val newNode = node.asInstanceOf[AggOpNew[T1, T2]]
      aggOpConsume[T1, T2](self.asInstanceOf[Rep[AggOp[T1, T2]]], tuple)(newNode.typeA, newNode.typeB)
    case Def(node: MapOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[MapOpNew[T1]]
      mapOpConsume[T1](self.asInstanceOf[Rep[MapOp[T1]]], tuple)(newNode.typeA)
    case Def(node: SortOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SortOpNew[T1]]
      sortOpConsume[T1](self.asInstanceOf[Rep[SortOp[T1]]], tuple)(newNode.typeA)
    case Def(node: HashJoinOpNew1[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew1[T1, T2, T3]]
      hashJoinOpConsume[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]], tuple)(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: HashJoinOpNew2[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinOpNew2[T1, T2, T3]]
      hashJoinOpConsume[T1, T2, T3](self.asInstanceOf[Rep[HashJoinOp[T1, T2, T3]]], tuple)(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: WindowOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[WindowOpNew[T1, T2, T3]]
      windowOpConsume[T1, T2, T3](self.asInstanceOf[Rep[WindowOp[T1, T2, T3]]], tuple)(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: LeftHashSemiJoinOpNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[LeftHashSemiJoinOpNew[T1, T2, T3]]
      leftHashSemiJoinOpConsume[T1, T2, T3](self.asInstanceOf[Rep[LeftHashSemiJoinOp[T1, T2, T3]]], tuple)(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: NestedLoopsJoinOpNew[_, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      val newNode = node.asInstanceOf[NestedLoopsJoinOpNew[T1, T2]]
      nestedLoopsJoinOpConsume[T1, T2](self.asInstanceOf[Rep[NestedLoopsJoinOp[T1, T2]]], tuple)(newNode.typeA, newNode.typeB)
    case Def(node: SubquerySingleResultNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[SubquerySingleResultNew[T1]]
      subquerySingleResultConsume[T1](self.asInstanceOf[Rep[SubquerySingleResult[T1]]], tuple)(newNode.typeA)
    case Def(node: HashJoinAntiNew[_, _, _]) =>
      type T1 = Any
      type T2 = Any
      type T3 = Any
      val newNode = node.asInstanceOf[HashJoinAntiNew[T1, T2, T3]]
      hashJoinAntiConsume[T1, T2, T3](self.asInstanceOf[Rep[HashJoinAnti[T1, T2, T3]]], tuple)(newNode.typeA, newNode.typeB, newNode.typeC)
    case Def(node: ViewOpNew[_]) =>
      type T1 = Any
      val newNode = node.asInstanceOf[ViewOpNew[T1]]
      viewOpConsume[T1](self.asInstanceOf[Rep[ViewOp[T1]]], tuple)(newNode.typeA, newNode.evidence$1)
    case Def(node: LeftOuterJoinOpNew[_, _, _]) =>
      type T1 = ch.epfl.data.pardis.shallow.Record
      type T2 = ch.epfl.data.pardis.shallow.Record
      type T3 = Any
      val newNode = node.asInstanceOf[LeftOuterJoinOpNew[T1, T2, T3]]
      leftOuterJoinOpConsume[T1, T2, T3](self.asInstanceOf[Rep[LeftOuterJoinOp[T1, T2, T3]]], tuple)(newNode.typeA, newNode.typeB, newNode.typeC, newNode.evidence$2)
    case _ => super.operatorConsume[A](self, tuple)(typeA)
  }
}
trait OperatorsComponent extends OperatorComponent with ScanOpComponent with PrintOpComponent with SelectOpComponent with AggOpComponent with MapOpComponent with SortOpComponent with HashJoinOpComponent with WindowOpComponent with LeftHashSemiJoinOpComponent with NestedLoopsJoinOpComponent with SubquerySingleResultComponent with HashJoinAntiComponent with ViewOpComponent with LeftOuterJoinOpComponent { self: DeepDSL => }