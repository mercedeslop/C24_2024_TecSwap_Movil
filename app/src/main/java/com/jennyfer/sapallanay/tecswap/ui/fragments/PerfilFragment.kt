package com.jennyfer.sapallanay.tecswap.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jennyfer.sapallanay.tecswap.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private var callback: SignOutCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SignOutCallback) {
            callback = context
        } else {
            throw RuntimeException("$context must implement SignOutCallback")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCerrarSesion.setOnClickListener {
            callback?.signOut()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface SignOutCallback {
        fun signOut()
    }
}