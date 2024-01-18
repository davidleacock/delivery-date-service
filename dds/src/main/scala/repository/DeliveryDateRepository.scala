package repository

import cats.effect.IO
import domain.DeliveryDate

import java.util.UUID

trait DeliveryDateRepository {
  def getDeliveryDate(packageId: UUID): IO[Option[DeliveryDate]]
  def updateDeliveryDate(deliveryDate: DeliveryDate): IO[Unit]
}

