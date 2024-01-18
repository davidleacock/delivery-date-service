package service

import cats.effect.IO
import domain.DeliveryDate

import java.time.Instant
import java.util.UUID

trait DeliveryDateService {
  def updateDeliveryDate(packageId: UUID, eventCode: Int, newDate: Instant): IO[Unit]
  def getDeliveryDate(packageId: UUID): IO[Option[DeliveryDate]]
}
