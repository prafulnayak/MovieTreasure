package org.sairaa.moivetreasure.Model


data class MovieData (val comingsoon: List<MovieT>,
                      val movieintheaters: List<MovieT>,
                      val indianmovies: List<MovieT>)

data class MovieT (val id:String?= null,
                   val title: String,
                   val year: String,
                   val genres: List<String>,
                   val ratings: List<Double>,
                   val poster: String,
                   val contentRating: String,
                   val duration: String,
                   val releaseDate: String,
                   val averageRating: String,
                   val originalTitle: String,
                   val storyline: String,
                   val actors: List<String>,
                   val imdbRating: String,
                   val posterurl: String)




