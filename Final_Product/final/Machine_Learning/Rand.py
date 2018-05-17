import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
import matplotlib.pyplot as plt
import csv
from sklearn.model_selection import cross_val_score
features = pd.read_csv('Agm_new.csv')
pred_data = pd.read_csv('Agri.csv')
features = pd.get_dummies(features)
pred_features = pd.get_dummies(pred_data)
flag = np.array(features['Modal_Price_(Rs./Quintal)'])
features = features.drop('Modal_Price_(Rs./Quintal)',axis=1)
features_list = list(features.columns)
pred_features_list = list(pred_features.columns)
features=np.array(features)
#X_train,X_test,Y_train,Y_test = train_test_split(features,flag,test_size=0.25,random_state=42)
#print('Training Features Shape:', X_train.shape)
#print('Training Labels Shape:', Y_train.shape)
#print('Testing Features Shape:', X_test.shape)
#print('Testing Labels Shape:', Y_test.shape)
rf = RandomForestRegressor(n_estimators=160,random_state=35)
#score = cross_val_score(rf,features,flag,cv=10)
#print(score)
rf.fit(features,flag)
#pred = rf.predict(X_test)
#error = abs(pred - Y_test)
#quil = 100*(np.sum(error)/np.sum(Y_test))
#accuracy = 100 - np.mean(quil)
#print(accuracy,"%")
#f = open('Accuracy.csv','w')
#f.write(str(accuracy) + ',')
#f.close()
#estimators = np.arange(30,60,5)
#score = list()
#plt.plot(Y_test[0:10],'ro')
##plt.plot(pred[0:10])
#plt.show()
#for i in estimators:
#    rf = RandomForestRegressor(n_estimators=160,random_state=i)
#    rf.fit(features,flag)
#    mean_error = np.mean(cross_val_score(rf,features,flag,cv =10))
#   score.append(mean_error)
#plt.xlabel('estimators')
#plt.ylabel('cv_error')
#plt.plot(estimators,score)
#plt.show()

#prediction = rf.predict(pred_features)
#a = np.array(prediction)
##a=a.astype(int)
#pred_data["Price"] = a.T
#pred_data.to_csv('Result.csv')
prediction = rf.predict(pred_features)
a = np.array(prediction)
a=a.astype(int)
pred_data["Price"] = a.T
pred_data.to_csv('Result.csv')
