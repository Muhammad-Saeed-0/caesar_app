class CipherClass {
   private val alpha = "abcdefghijklmnopqrstuvwxyz !@#$"
        private var alphaLen = alpha.length

        fun  encryption(plainText: String, k: Int = 4) : String
        {
            var plainLen = plainText.length
            var cipher = ""

            for (item in plainText)
            {
                cipher +=  alpha[ (k + alpha.indexOf(item)) % alphaLen ]
            }
            return cipher
        }

        fun  decryption(cipherText: String, k: Int = 4) : String
        {
            var cipherLen = cipherText.length
            var plain = ""

            for (item in cipherText)
            {
                var temp = (alpha.indexOf(item) - k) % alphaLen
                if (temp < 0)
                {
                    temp = (alphaLen + alpha.indexOf(item) - k) % alphaLen
                }
                plain +=  alpha[temp]
            }
            return plain
        }
}