package com.jennyfer.sapallanay.tecswap.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jennyfer.sapallanay.tecswap.R
import com.jennyfer.sapallanay.tecswap.databinding.ActivityMain2Binding
import com.jennyfer.sapallanay.tecswap.ui.fragments.ExplorarFragment
import com.jennyfer.sapallanay.tecswap.ui.fragments.FavoritosFragment
import com.jennyfer.sapallanay.tecswap.ui.fragments.PerfilFragment
import com.jennyfer.sapallanay.tecswap.ui.fragments.ProductosFragment
import com.jennyfer.sapallanay.tecswap.ui.fragments.TruequesFragment

class MainActivity2 : AppCompatActivity(), PerfilFragment.SignOutCallback {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Para manejar los fragmentos
        binding.bottomNavMenu.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mExplora -> {
                    replaceFragment(ExplorarFragment())
                    true
                }
                R.id.mTrueque -> {
                    replaceFragment(TruequesFragment())
                    true
                }
                R.id.mProducto -> {
                    replaceFragment(ProductosFragment())
                    true
                }
                R.id.mPerfil -> {
                    replaceFragment(PerfilFragment())
                    true
                }
                R.id.mFavorito -> {
                    replaceFragment(FavoritosFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(ExplorarFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
    }

    override fun signOut() {
        Firebase.auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}