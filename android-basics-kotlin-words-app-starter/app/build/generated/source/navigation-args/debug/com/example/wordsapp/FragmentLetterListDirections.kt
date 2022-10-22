package com.example.wordsapp

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class FragmentLetterListDirections private constructor() {
  private data class ActionFragmentLetterListToFragmentWordList(
    public val letter: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentLetterList_to_fragmentWordList

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("letter", this.letter)
        return result
      }
  }

  public companion object {
    public fun actionFragmentLetterListToFragmentWordList(letter: String): NavDirections =
        ActionFragmentLetterListToFragmentWordList(letter)
  }
}
