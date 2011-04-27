package net.liftweb.mappedpostalcode.model

import net.liftweb._
import mapper._
import http._
import S._
import java.util.regex.Pattern

class Address extends LongKeyedMapper[Address] with IdPK {
  def getSingleton = Address

  object street extends MappedString(this, 64) {
    override def displayName = S.?("street")
  }

  // 1. Start like this:
  object postal extends MappedString(this, 20)

  //      2. Change to this:
  //        object postal extends MappedPostalCode(this, country) {
  ////            override def validations = super.validations
  //        }

  //    3. Then toggle the validation def to see the validation come and go away

  object country extends MappedCountry(this) {
    override def defaultValue = Countries.Sweden
  }

}
object Address extends Address with LongKeyedMetaMapper[Address] with CRUDify[Long, Address] {
}