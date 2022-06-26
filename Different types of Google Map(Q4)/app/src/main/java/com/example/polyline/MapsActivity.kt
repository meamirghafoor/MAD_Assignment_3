package com.example.polyline
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    var css = LatLng(30.5792141, 71.2369336)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        var hybridMapBtn: Button?  = findViewById(R.id.btn3)
        var terrainMapBtn: Button? = findViewById(R.id.btn1)
        var satelliteMapBtn: Button? = findViewById(R.id.btn2)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        hybridMapBtn?.setOnClickListener(View.OnClickListener {
            mMap!!.mapType = GoogleMap.MAP_TYPE_HYBRID
        })
        terrainMapBtn?.setOnClickListener(View.OnClickListener {
            mMap!!.mapType = GoogleMap.MAP_TYPE_TERRAIN
        })
        satelliteMapBtn?.setOnClickListener(View.OnClickListener {
            mMap!!.mapType = GoogleMap.MAP_TYPE_SATELLITE
        })
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap!!.addMarker(MarkerOptions().position(css).title("Marker in Chowk Munda"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(css,14f))
    }
}

