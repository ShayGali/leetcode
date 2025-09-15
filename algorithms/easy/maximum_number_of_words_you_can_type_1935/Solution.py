class Solution:
    # aglo way, only one pass
    def canBeTypedWords1(self, text: str, brokenLetters: str) -> int:
        is_broke = [False] * 26
        for ch in brokenLetters:
            is_broke[ord(ch) - 97] = True

        count = 0
        i = 0
        while i < len(text):
            ch = text[i]
            if ch == " ":
                count += 1

            elif is_broke[ord(ch) - 97]:
                while i < len(text) and text[i] != " ":
                    i += 1
            elif i == len(text) -1:
                count += 1
            i += 1

        return count

    # pythonic way, two pass
    def canBeTypedWords2(self, text: str, brokenLetters: str) -> int:
        broken_set = set(brokenLetters)
        count = 0
        for word in text.split(" "):
            if not any((ch in broken_set) for ch in word):
                count += 1
        return count
