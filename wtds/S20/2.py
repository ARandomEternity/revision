import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
text = """Hello all, Welcome to Python Programming Academy. Python Programming Academy is a nice platform to learn new programming skills. It is difficult to get enrolled in this Academy."""
words = word_tokenize(text.lower())
stop_words = set(stopwords.words('english'))
filtered_words = [word for word in words if word not in stop_words]
filtered_text = ' '.join(filtered_words)
print("Original text:\n", text)
print("\nText after removing stopwords:\n", filtered_text)
