import matplotlib.pyplot as plt
from sklearn import linear_model
from sklearn.metrics import r2_score,mean_squared_error
from sklearn.model_selection import train_test_split
import numpy as np
import pandas as pd
df = pd.read_csv('Agm_new.csv')
X_true = pd.get_dummies(df)
Y_true = np.array(X_true['Modal Price (Rs./Quintal)'])
X_true = X_true.drop('Modal Price (Rs./Quintal)',axis=1)
X_train,X_test,Y_train,Y_test = train_test_split(X_true,Y_true,test_size=0.25,random_state=42)
clf = linear_model.Ridge(alpha=0.1)
clf.fit(X_train,Y_train)
pred = clf.predict(X_test)
error = abs(pred - Y_test)
quil = 100*(error/Y_test)
accuracy = 100 - np.mean(quil)
print(accuracy,"%")