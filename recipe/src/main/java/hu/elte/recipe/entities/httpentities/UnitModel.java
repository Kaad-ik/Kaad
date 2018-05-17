package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.IngredientUnitType;

import java.util.List;

/**
 * The Class UnitModel.
 */
public class UnitModel {

  /** The available units. */
  private List<IngredientUnitType> availableUnits;

  /**
   * Instantiates a new unit model.
   *
   * @param availableUnits the available units
   */
  public UnitModel(List<IngredientUnitType> availableUnits) {
    this.availableUnits = availableUnits;
  }

  /**
   * Gets the available units.
   *
   * @return the available units
   */
  public List<IngredientUnitType> getAvailableUnits() {
    return availableUnits;
  }

}
