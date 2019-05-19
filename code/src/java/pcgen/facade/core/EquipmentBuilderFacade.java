/*
 * Copyright 2013 (C) James Dempsey <jdempsey@users.sourceforge.net>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.facade.core;

import java.util.EnumSet;

import pcgen.core.EquipmentModifier;
import pcgen.core.SizeAdjustment;
import pcgen.facade.util.ListFacade;
import pcgen.facade.util.ReferenceFacade;

/**
 * EquipmentBuilderFacade defines the methods that can be used to build up a 
 * piece of custom equipment.
 * 
 * 
 */
public interface EquipmentBuilderFacade
{
	/**
	 * EquipmentHead marks the ends of a weapon that may be customized. Most 
	 * weapons only have one head but quarterstaves or the like have two.
	 */
	public enum EquipmentHead
	{
		PRIMARY, SECONDARY;

		/**
		 * @return boolean {@code true} is Primary
		 */
		public boolean isPrimary()
		{
			return this == PRIMARY;
		}
	}

	public boolean addModToEquipment(EquipmentModifier modifier, EquipmentHead head);

	public boolean removeModFromEquipment(EquipmentModifier modifier, EquipmentHead head);

	public boolean setName(String name);

	public boolean setSProp(String sprop);

	public boolean setCost(String newCost);

	public boolean setWeight(String newWeight);

	public ListFacade<EquipmentModifier> getAvailList(EquipmentHead head);

	public ListFacade<EquipmentModifier> getSelectedList(EquipmentHead head);

	public EquipmentFacade getEquipment();

	/**
	 * Can this item of equipment be resized?
	 * @return true if the item can be resized
	 */
	public boolean isResizable();

	/**
	 * @param newSize The new size for the equipment.
	 */
	public void setSize(SizeAdjustment newSize);

	/**
	 * @return A reference to the equipment's current size.
	 */
	public ReferenceFacade<SizeAdjustment> getSizeRef();

	/**
	 * @return The equipment heads which can be customized on this item of equipment.
	 */
	public EnumSet<EquipmentHead> getEquipmentHeads();

	/**
	 * @param newValue
	 * @return boolean
	 */
	boolean setDamage(String newValue);

	/**
	 * @return String Base Item Name
	 */
	public String getBaseItemName();

	/**
	 * @return boolean
	 */
	public boolean isWeapon();

	/**
	 * @return String Damage
	 */
	public String getDamage();

}
