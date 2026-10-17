package com.mynim_123140148.praktikumpam01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

const val JUDUL_APLIKASI = "Agenda Kegiatan UKM"

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            var tampilTentang by remember { mutableStateOf(false) }
            if (tampilTentang) {
                TentangScreen(onKembali = { tampilTentang = false })
            } else {
                BerandaScreen(onTentang = { tampilTentang = true })
            }
        }
    }
}

@Composable
fun BerandaScreen(onTentang: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().safeContentPadding().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = JUDUL_APLIKASI,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        // nama platform diambil lewat expect/actual getPlatform()
        Text("Berjalan di ${getPlatform().name}", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onTentang) { Text("Tentang") }
    }
}

@Composable
fun TentangScreen(onKembali: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().safeContentPadding().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Tentang", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Tema 9: $JUDUL_APLIKASI", style = MaterialTheme.typography.titleMedium)
        Text("Anggota kelompok:", style = MaterialTheme.typography.labelLarge)
        daftarAnggota.forEach { anggota ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(anggota.nama, fontWeight = FontWeight.Bold)
                    Text("${anggota.nim} - ${anggota.peran}")
                }
            }
        }
        TextButton(onClick = onKembali) { Text("Kembali") }
    }
}
