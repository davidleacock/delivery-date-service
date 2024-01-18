package repository

import cats.effect.IO
import domain.DeliveryDate

import java.util.UUID
import scala.collection.mutable

class InMemoryDeliveryDateRepository extends DeliveryDateRepository {

  private val memory = mutable.Map.empty[UUID, DeliveryDate]

  override def getDeliveryDate(packageId: UUID): IO[Option[DeliveryDate]] = {
    IO {
      memory.get(packageId)
    }
  }

  override def updateDeliveryDate(deliveryDate: DeliveryDate): IO[Unit] = {
    IO {
      memory.getOrElse(deliveryDate.packageId, deliveryDate)
    }
  }
}
