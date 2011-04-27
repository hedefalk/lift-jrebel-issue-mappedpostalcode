package net.liftweb.mappedpostalcode.snippet

import net.liftweb.common.Logger
import net.liftweb.mappedpostalcode.model.Address
import net.liftweb.http.LiftScreen
object AddressScreen extends LiftScreen with Logger {
  object address extends ScreenVar(Address.create)
  
  def addMyField() {
    addFields(() => address.is)
  }
  
  addMyField
  def finish() {

  }
}
