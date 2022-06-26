package com.example.polyline

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    var lahore = LatLng(31.721159, 74.273758)
    var isb = LatLng(33.673038, 72.984138)
    var multan = LatLng(30.181459, 71.492157)
    var bwpl = LatLng(29.418068, 71.670685)
    var okara = LatLng(30.813802, 73.453378)
    var khanwel = LatLng(30.286415, 71.932030)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap!!.addPolyline(
            PolylineOptions().add(lahore,isb,multan,khanwel,bwpl,okara,lahore).width(7f)
                .color(Color.RED).geodesic(true)
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(isb, 7f))
    }
}


