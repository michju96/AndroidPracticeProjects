package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class Datasource {
    fun loadAffirmations():List<Affirmation>{

        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1,R.drawable.anonymous),
            Affirmation(R.string.affirmation2,R.drawable.ao4k),
            Affirmation(R.string.affirmation3,R.drawable.anonimus),
            Affirmation(R.string.affirmation4,R.drawable.bagieta),
            Affirmation(R.string.affirmation5,R.drawable.podryw),
            Affirmation(R.string.affirmation6,R.drawable.johnwick),
            Affirmation(R.string.affirmation7,R.drawable.awek_floriena),
            Affirmation(R.string.affirmation8,R.drawable.bandyta)
            )
        }
    }
