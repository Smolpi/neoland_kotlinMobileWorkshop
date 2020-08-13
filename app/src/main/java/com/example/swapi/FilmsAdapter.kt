package com.example.swapi

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class FilmsAdapter(private var filmList : List<Film>) : RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {


    class FilmsViewHolder(root: View, var twFilm: TextView, var twDescription: TextView, var iwLogo: ImageView) : RecyclerView.ViewHolder(root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_layout, parent, false)
        val twFilm = view.findViewById<TextView>(R.id.text_view_film_name)
        val twPlanets = view.findViewById<TextView>(R.id.text_view_film_planets)
        val iwLogo = view.findViewById<ImageView>(R.id.image_view_logo)

        return FilmsViewHolder(view, twFilm, twPlanets, iwLogo)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.twFilm.text = filmList[position].title
        holder.twDescription.text = filmList[position].openingCrawl
        holder.itemView.setOnClickListener { openChrome(holder.twDescription.context, filmList[position]) }

        Picasso.get().load(filmList[position].getUrlImage()).into(holder.iwLogo)
    }

    private fun openChrome(context : Context, film: Film) {
        val titleCleaned = film.title.replace(" ", "+")
        val url = "http://www.google.com/search?q=$titleCleaned+Star+Wars+youtube+trailer&btnI"
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }

    fun updateData(filmList : List<Film>) {
        this.filmList = filmList
    }
}