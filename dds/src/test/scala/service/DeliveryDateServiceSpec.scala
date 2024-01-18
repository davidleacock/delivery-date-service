package service

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import repository.InMemoryDeliveryDateRepository
import service.impl.DeliveryDateServiceImpl
import cats.effect.IO
import cats.effect.unsafe.implicits.global

import java.time.Instant
import java.util.UUID

class DeliveryDateServiceSpec extends AnyWordSpec with Matchers {

  val service = new DeliveryDateServiceImpl(new InMemoryDeliveryDateRepository)

  "DeliveryDateService" should {

    "update delivery date for a valid package" in {
      val packageId = UUID.randomUUID()
      val result: Unit = service
        .updateDeliveryDate(packageId, 1234, Instant.now())
        .unsafeRunSync()

      result shouldBe ()
    }

    "handle non-existing package IDs by creating a new instance" in {}

    "handle a failed attempt at updating delivery date" in {}

    "retrieve delivery date for existing package" in {}

    "return nothing when package does not exist" in {}
  }
}
