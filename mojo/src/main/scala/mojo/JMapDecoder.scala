package mojo

trait JMapDecoder[A] {
  
}

object JMapDecoder {
  def apply[A](implicit a: JMapDecoder[A]): JMapDecoder[A] = a
}