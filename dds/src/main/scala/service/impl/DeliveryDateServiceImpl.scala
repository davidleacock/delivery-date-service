package service.impl

import cats.effect.IO
import domain.DeliveryDate
import repository.DeliveryDateRepository
import service.DeliveryDateService

import java.time.Instant
import java.util.UUID

class DeliveryDateServiceImpl(repo: DeliveryDateRepository)
    extends DeliveryDateService {
  override def updateDeliveryDate(
    packageId: UUID,
    eventCode: Int,
    newDate: Instant
  ): IO[Unit] =
    repo.updateDeliveryDate(
      DeliveryDate(packageId, eventCode, deliveryDate = newDate, Instant.now())
    )

  override def getDeliveryDate(packageId: UUID): IO[Option[DeliveryDate]] =
    repo.getDeliveryDate(packageId)

}
