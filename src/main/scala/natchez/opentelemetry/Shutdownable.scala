package natchez.opentelemetry

import io.opentelemetry.sdk.common.CompletableResultCode
import io.opentelemetry.sdk.trace.{SdkTracerProvider, SpanProcessor}
import io.opentelemetry.sdk.trace.`export`.SpanExporter

// abstracts over all the ways Otel classes can be shut down, they don't have a common interface so let's make one
trait Shutdownable[-T] {
  def shutdown(t: T): CompletableResultCode
}
object Shutdownable {
  def apply[T: Shutdownable]: Shutdownable[T] = implicitly
  implicit val spanExporter: Shutdownable[SpanExporter]   = (t: SpanExporter) => t.shutdown()
  implicit val spanProcessor: Shutdownable[SpanProcessor] = (t: SpanProcessor) => t.shutdown()
  implicit val tracer: Shutdownable[SdkTracerProvider]    = (t: SdkTracerProvider) => t.shutdown()
}