package domain

import java.time.Instant
import java.util.UUID

case class DeliveryDate(
  packageId: UUID,
  eventCode: Int,
  deliveryDate: Instant,
  latestUpdate: Instant)



