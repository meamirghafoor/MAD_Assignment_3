package com.example.polyline
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    var lahore = LatLng(31.582045, 74.329376)
    var bwl = LatLng( 30.181459, 71.492157)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        googleMap.addMarker(
            MarkerOptions()
                .position(lahore)
        )
        googleMap.addMarker(
            MarkerOptions()
                .position(bwl)
        )
        mMap!!.addPolyline(
            PolylineOptions().add(lahore,bwl)
                .width
                    (5f)
                .color(Color.BLUE)
                .geodesic(true)
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lahore, 13f))
    }
}
