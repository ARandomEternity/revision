
import re
from nltk.corpus import stopwords
from nltk.tokenize import sent_tokenize, word_tokenize
from heapq import nlargest
text = '''So, keep working. Keep striving. Never give up. Fall down seven times, get up eight. Ease is a greater threat to progress than hardship. Ease is a greater threat to progress than hardship. So, keep moving, keep growing, keep learning. See you at work.'''
text = re.sub(r'\d+', '', text)  
text = re.sub(r'[^\w\s]', '', text)  
sentences = sent_tokenize(text)  
words = word_tokenize(text.lower())  
stop_words = set(stopwords.words('english'))  
word_frequencies = {}  
for word in words:
    if word not in stop_words:
        if word not in word_frequencies:
            word_frequencies[word] = 1
        else:
            word_frequencies[word] += 1
sentence_scores = {}
for sentence in sentences:
    for word in word_tokenize(sentence.lower()):
        if word in word_frequencies:
            if len(sentence.split(' ')) < 30:  
                if sentence not in sentence_scores:
                    sentence_scores[sentence] = word_frequencies[word]
                else:
                    sentence_scores[sentence] += word_frequencies[word]
summary_sentences = nlargest(2, sentence_scores, key=sentence_scores.get)
summary = ' '.join(summary_sentences)
print("Original text:\n", text)
print("\nSummary:\n", summary)