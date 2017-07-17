package edu.illinois.npre.rdii.kriging


import scala.math

/**
  * Created by karoth on 6/30/17.
  */
class UniversalKriging(val points: Array[Double],
                       val model: String) {
  /**
    *
    * points: Dataset[T]      // Array containing lat, lon, and Z-value
    *
    * x_coord: Array[Double]  // array of x-coordinates
    * y_coord: Array[Double]  // array of y-coordinates
    * z_values: Array[Double] // array of z-values at (x,y) coordinate
    *
    * model: String           // Semivariogram model: {"Linear", "Exponential",
    *                         // "Gaussian", "Spherical"}
    * c0: Double              // Nugget of the semivariogram
    * c: Double               // Sill of the semivariogram
    * a: Double               // Range of the semivariogram
    *
    * Blah Blah
    */

  def fit(): Unit = {

  }

  def semivariogram(c0_range: Double, c_range: Double, a_range: Double): Unit = {
  /**
    * Wrapper Function for plotting semivariograms
    *
    * TO DO:
    */


  }

  def _semivariogram(lags: Array[Double], model: String ): List[(Double, Double)] = {
    /**
      * 'gamma' is a List of Tuples containing a distance,
      *  and its corresponding gamma value
      *
      *  TODO:
      *  1. Create a Point data structure (Import geotrellis?)
      *  2. Grid experimental area, and average Points (IDW?)
      *  3. Compute pairwise distance on averaged points (where to store data?)
      *
      *     a. "creating a distributed matrix solver using a transformation (like .map) would be the best solution"
      *     b. Distance Matrix... No two points will have the same (x,y) coordinates
      *
      *  4. Compute semivariogram values for different distances
      *
      *
      *
      *
       */
    val gamma: List[(Double, Double)] = List.fill(lags.length) (_fit_model() )

      gamma
  }

  def _fit_model( ): (Double,Double) = {
    /**
      * Function to fit semivariogram model by minimizing MSE
      * model types: "exponential", "spherical", "gaussian"
      */
  }

  def _fit( ) {


  }

  def linearVariogramModel(m: List[Double], d: List[(Double,Double)]): List[Double] = {
    if(m.length == 2) {
      val slope: Double = m(0)
      val nugget: Double = m(1)

      return d.map( x => slope*x + nugget )
      //return some List of doubles by mapping
      // g[i] = slope * d[i] + nugget
    }
    else {
      throw new Exception("INVALID INPUT: The Linear Model requires 2 elements: slope and nugget")
    }
  }

  def exponentialVariogramModel(m: List[Double], d: List[(Double,Double)]): List[Double] = {
    if(m.length == 3) {
      val psill: Double = m(0)
      val range: Double = m(1)
      val nugget: Double = m(2)

      //return some List of doubles by mapping
      // g[i] = psill * (1. - exp(- d[i] /(range/3.))) + nugget
    }
    else {
      throw new Exception("INVALID INPUT: The Exponential Model requires 3 elements: psill, range, and nugget.")
    }
  }

  def gaussianVarogramModel(m: List[Double], d: List[(Double,Double)]): List[Double] = {
    if(m.length == 3) {
      val psill: Double = m(0)
      val range: Double = m(1)
      val nugget: Double = m(2)

      //return some List of doubles by mapping
      // g[i] = psill * (1. - exp(-d**2./(range*4./7.)**2.)) + nugget
    }
    else {
      throw new Exception("INVALID INPUT: The Gaussian Model requires 3 elements: psill, range, and nugget.")
    }
  }

  def sphericalVariogramModel(m: List[(Double, Double, Double)], d: List[(Double,Double)]): List[Double] = {
    if(m.length == 3) {
      val psill: Double = m(0)
      val range: Double = m(1)
      val nugget: Double = m(2)
    }
    else {
      throw new Exception("INVALID INPUT: The Spherical Model requires 3 elements: psill, range, and nugget.")
    }
  }

}
